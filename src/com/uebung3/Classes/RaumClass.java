package com.uebung3.Classes;

import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Enumerations.Unterrichtstag;
import com.uebung3.Interfaces.RaumInterface;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RaumClass implements RaumInterface {

    private String raumNummer;
    private int maxSitzplaetze;
    private Raumtyp raumtyp;

    private KlasseClass stammklasse;
    private ArrayList<FachClass> faecher;

    public RaumClass(String raumNummer, int maxSitzplaetze, Raumtyp raumtyp) {
        this.raumNummer = raumNummer;
        this.maxSitzplaetze = maxSitzplaetze;
        this.raumtyp = raumtyp;

        this.faecher = new ArrayList<FachClass>();
    }

    @Override
    public String getRaumNummer() {
        return this.raumNummer;
    }

    @Override
    public int getMaxSitzplaetze() {
        return this.maxSitzplaetze;
    }

    @Override
    public Raumtyp getRaumtyp() {
        return this.raumtyp;
    }

    @Override
    public boolean setStammklasse(KlasseClass klasse) {
        try {
            this.stammklasse = klasse;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public KlasseClass getStammklasse() { return this.stammklasse; }

    @Override
    public boolean addFach(FachClass fach) {
        try {
            if(!this.faecher.contains(fach)) {
                this.faecher.add(fach);
                return true;
            } else
                throw new Exception("Fach existiert bereits.");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<FachClass> getFaecher() { return this.faecher; }


    @Override
    public void exportBelegung(ArrayList<BelegungClass> belegung) {

        String[] zeiten = {"7:50", "8:40", "9:40", "10:30", "11:20", "12.20", "13:10", "14:00", "15:00" , "15:50"};
        String[] pausen_zeiten = {"9:30", "12:10", "14:50"};
        int pausen_count=0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Stundenplan für " + this.raumNummer);


        int rowCount = 0;
        int columnCount = 0;
        Integer initalColumn = 5;

        // Vorbereitung des Excel-Sheets

        CellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);
        // 1. Zeile

        Row row = sheet.createRow(rowCount++);

        Cell cell = row.createCell(columnCount = 2);
        cell.setCellStyle(cs);

        cell = row.createCell(columnCount++);
        cell.setCellValue("Stundenplan für " + this.raumNummer);

        // 2. Zeile
        row = sheet.createRow(rowCount++);
        cell = row.createCell(columnCount = 1);
        cell.setCellStyle(cs);

        for(int i = 0; i < 5; i++) {

            cell = row.createCell(columnCount++);
            cell.setCellStyle(cs);
            cell.setCellValue(Unterrichtstag.values()[i].toString());
        }

        for(int i=1; i<11; i++) {

            if(i==3 || i==6 || i==9){
                row = sheet.createRow(rowCount++);
                cell = row.createCell(columnCount = 0);
                cell.setCellStyle(cs);
                cell.setCellValue(pausen_zeiten[pausen_count++]);
                for (int k=0; k<5; k++){
                    cell = row.createCell(++columnCount);
                    cell.setCellStyle(cs);
                    cell.setCellValue("Pause");
                }
            }

            row = sheet.createRow(rowCount++);
            row.setHeightInPoints((3*sheet.getDefaultRowHeightInPoints()));
            cell = row.createCell(columnCount = 0);
            cell.setCellStyle(cs);

            cell = row.createCell(columnCount++);
            cell.setCellStyle(cs);
            cell.setCellValue(zeiten[i-1]);

            for (int j = 0; j < 5; j++) {

                cell = row.createCell(columnCount++);
                cell.setCellStyle(cs);

                for (BelegungClass belegung1 : belegung) {

                    if (belegung1.getRaum().getRaumNummer().equals(this.raumNummer)){
                        if(belegung1.getWochentag()== Unterrichtstag.values()[j] && belegung1.getStunde()==i){
                            cell.setCellValue(belegung1.getFach().getName() + "\n" + belegung1.getKlasse().getBezeichnung() + "\n" + belegung1.getLehrer().getKuerzel());
                        }
                    }
                }
            }
        }
        sheet.autoSizeColumn(4);

        try(FileOutputStream outputStream = new FileOutputStream("./data/Raum/" + this.raumNummer + ".xlsx")) {

            workbook.write(outputStream);

        } catch(FileNotFoundException e) {

            e.printStackTrace();

        } catch(IOException e1) {

            e1.printStackTrace();

        }
    }

    @Override
    public String toString() {
        return this.raumNummer + " - " + this.maxSitzplaetze + " - " + this.raumtyp;
    }
}
