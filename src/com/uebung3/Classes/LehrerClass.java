package com.uebung3.Classes;

import com.uebung3.Enumerations.Unterrichtstag;
import com.uebung3.Interfaces.LehrerInterface;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class LehrerClass extends MitarbeiterClass implements LehrerInterface {

    private String kuerzel;

    private ArrayList<FachClass> faecher;

    public LehrerClass(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, String kuerzel) {
        super(svnr, vorname, nachname, geburtsdatum, email);
        this.kuerzel = kuerzel;
        this.faecher = new ArrayList<FachClass>();
    }

    @Override
    public String getKuerzel() {
        return this.kuerzel;
    }

    @Override
    public boolean addFach(FachClass fach) {
        try {
            this.faecher.add(fach);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<FachClass> getFaecher() { return this.faecher; }

    @Override
    public void exportStundenplan(ArrayList<BelegungClass> belegung) {

        String[] zeiten = {"7:50", "8:40", "9:40", "10:30", "11:20", "12.20", "13:10", "14:00", "15:00" , "15:50"};

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Stundenplan für " + this.kuerzel);

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
        cell.setCellValue("Stundenplan für " + this.kuerzel);

        // 2. Zeile
        row = sheet.createRow(rowCount++);
        cell = row.createCell(columnCount = 1);
        cell.setCellStyle(cs);

        for(int i = 0; i < 5; i++) {

            cell = row.createCell(columnCount++);
            cell.setCellStyle(cs);
            cell.setCellValue(Unterrichtstag.values()[i].toString());
        }

        for(int i=0; i<10; i++) {

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

                    if (belegung1.getLehrer().getKuerzel().equals(this.kuerzel)){
                        if(belegung1.getWochentag()== Unterrichtstag.values()[j] && belegung1.getStunde()==i){
                            cell.setCellValue(belegung1.getFach().getName() + "\n" + belegung1.getKlasse().getBezeichnung() + "\n" + belegung1.getRaum().getRaumNummer());
                        }
                    }

                }
            }
            sheet.autoSizeColumn(4);

            try(FileOutputStream outputStream = new FileOutputStream("./data/Lehrer/" + this.kuerzel + ".xlsx")) {

                workbook.write(outputStream);

            } catch(FileNotFoundException e) {

                e.printStackTrace();

            } catch(IOException e1) {

                e1.printStackTrace();

            }
        }
    }

    @Override
    public String toString() {
        return this.getNachname() + " " + getVorname();
    }
}