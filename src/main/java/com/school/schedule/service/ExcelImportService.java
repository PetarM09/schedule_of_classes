package com.school.schedule.service;

import com.school.schedule.model.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExcelImportService {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private PredmetService predmetService;

    @Autowired
    private OdeljenjeService odeljenjeService;

    @Autowired
    private RazredService razredService;

    @Autowired
    private SmerService smerService;

    public void importDataFromExcel(MultipartFile file) throws Exception {
        // Umesto FileInputStream, koristimo InputStream direktno iz MultipartFile
        InputStream inputStream = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Prva kolona je ime i prezime profesora
            Cell nameCell = row.getCell(0);
            if (nameCell == null) continue; // Preskoči prazan red
            String fullName = nameCell.getStringCellValue();
            String[] nameParts = fullName.split(" ", 2);  // Razdvaja ime i prezime
            String firstName = nameParts[0];
            String lastName = nameParts.length > 1 ? nameParts[1] : "";

            // Kreiraj i sačuvaj profesora
            Profesor profesor = new Profesor();
            profesor.setIme(firstName);
            profesor.setPrezime(lastName);
            profesor = profesorService.save(profesor);  // Sačuvaj profesora u bazu

            // Sve ostale kolone su predmeti i odeljenja
            for (int i = 1; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                if (cell != null && !cell.getStringCellValue().isEmpty()) {
                    String cellData = cell.getStringCellValue();
                    parseAndSavePredmetOdeljenjeData(cellData, profesor);
                }
            }
        }
        workbook.close();
    }

    private void parseAndSavePredmetOdeljenjeData(String cellData, Profesor profesor) {
        String[] parts = cellData.split(":");
        String predmetNaziv = parts[0];
        String odeljenjeInfo = parts[1];
        String casoviInfo = parts[2];

        String[] odeljenjeParts = odeljenjeInfo.split("-");
        int razredNum = Integer.parseInt(odeljenjeParts[0]);
        String smerIndex = odeljenjeParts[1];

        String[] casoviParts = casoviInfo.split("\\+");
        int brojTeorijskihCasova = Integer.parseInt(casoviParts[0]);  // 4
        int brojVezbiCasova = Integer.parseInt(casoviParts[1]);  // 0

        // Kreiraj ili pronađi smer
        Smer smer = smerService.findByNaziv(getSmerNaziv(smerIndex));
        if (smer == null) {
            smer = new Smer();
            smer.setNaziv(getSmerNaziv(smerIndex)); // Metoda koja vraća naziv na osnovu indeksa
            smer = smerService.save(smer);
        }

        // Kreiraj ili pronađi razred
        Razred razred = razredService.findByNivo(razredNum);
        if (razred == null) {
            razred = new Razred();
            razred.setNivo(razredNum);
            razred = razredService.save(razred);  // Sačuvaj razred
        }



        // Kreiraj i sačuvaj predmet
        Predmet predmet = new Predmet();
        predmet.setNaziv(predmetNaziv);
        predmet.setBrojTeorijskihCasova(brojTeorijskihCasova);
        predmet.setBrojVezbiCasova(brojVezbiCasova);
        predmet.setSmer(smer);
        predmet.setRazred(razred);
        if(brojVezbiCasova == 0)
            predmet.setTipVezbi(TipVezbi.CELO_ODELJENJE);
        predmet = predmetService.save(predmet);

        // Kreiraj odeljenje sa pravilnim nazivom
        Odeljenje odeljenjeObj = new Odeljenje();
        odeljenjeObj.setRazred(razred);
        odeljenjeObj.setSmer(smer);
        odeljenjeObj.setNaziv(razredNum + "-" + smerIndex); // Postavi naziv odeljenja
        odeljenjeObj = odeljenjeService.save(odeljenjeObj); // Sačuvaj odeljenje

        // Veži profesora, predmet i odeljenje
        //Grupa grupa = new Grupa();
        //grupa.setPredmet(predmet);
        //grupa.setProfesor(profesor);
        //grupa.setBrojCasova(brojTeorijskihCasova + brojVezbiCasova);
        //grupa.getOdeljenja().add(odeljenjeObj);
        // Save Grupa logic...
    }

    private String getSmerNaziv(String index) {
        switch (index) {
            case "1":
                return "Prirodno-matematički";
            case "2":
                return "Opšti";
            case "3":
                return "Sportski";
            case "4":
            case "5":
                return "Društveno-jezički";
            case "6":
                return "IT";
            default:
                return "Nepoznat smer";
        }
    }

}