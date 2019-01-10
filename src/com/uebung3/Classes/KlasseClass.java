package com.uebung3.Classes;

import com.uebung3.Enumerations.Unterrichtstag;
import com.uebung3.Interfaces.KlasseInterface;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class KlasseClass implements KlasseInterface {

    private String bezeichnung;
    private int schulstufe;

    private LehrerClass klassenvorstand;
    private SchuelerClass klassensprecher;
    private ArrayList<SchuelerClass> schueler;
    private RaumClass stammklasse;
    private ArrayList<FachClass> faecher;           //Es kann ja nicht nur ein Fach unterrichtet werden, aber nur ein Fach einmal!
    private AbteilungClass abteilung;

    public KlasseClass(String bezeichnung, int schulstufe, AbteilungClass abteilung) {
        this.bezeichnung = bezeichnung;
        this.schulstufe = schulstufe;
        this.abteilung = abteilung;

        this.schueler = new ArrayList<SchuelerClass>();
        this.faecher = new ArrayList<FachClass>();
    }

    @Override
    public String getBezeichnung() {
        return this.bezeichnung;
    }

    @Override
    public int getSchulstufe() { return this.schulstufe; }

    @Override
    public float getDurchschnittsalter() {
        return 0;
    }

    @Override
    public int getSchuelerAnzahl() {
        return this.schueler.size();
    }

    @Override
    public AbteilungClass getAbteilung() { return this.abteilung; }

    @Override
    public ArrayList<SchuelerClass> getSchueler() { return this.schueler; }

    @Override
    public boolean setKlassensprecher(SchuelerClass schueler) {
        try {
            this.klassensprecher = schueler;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addSchueler(SchuelerClass schueler) {
        try {
            if(this.schueler.size() < 36) {
                this.schueler.add(schueler);
                return true;
            } else
                throw new Exception("Maximale Schueleranzahl erreicht!");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setKlassenvorstand(LehrerClass klassenvorstand) {
        try {
            this.klassenvorstand = klassenvorstand;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setStammklasse(RaumClass stammklasse) {
        try {
            this.stammklasse = stammklasse;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public RaumClass getStammklasse() { return this.stammklasse; }

    @Override
    public SchuelerClass getKlassensprecher() { return this.klassensprecher; }

    @Override
    public LehrerClass getKlassenvorstand() { return this.klassenvorstand; }

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
    public boolean setAbteilung(AbteilungClass abteilung) {
        try {
            this.abteilung = abteilung;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setBezeichnung(String bezeichnung) {
        try {
            this.bezeichnung = bezeichnung;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setSchulstufe(int schulstufe) {
        try {
            this.schulstufe = schulstufe;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void exportStundenplan(ArrayList<BelegungClass> belegung) {

        String[] zeiten = {"7:50", "8:40", "9:40", "10:30", "11:20", "12.20", "13:10", "14:00", "15:00" , "15:50"};

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Stundenplan für " + this.bezeichnung);


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
        cell.setCellValue("Stundenplan für " + this.bezeichnung);

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

                    if (belegung1.getKlasse().bezeichnung.equals(this.bezeichnung)){
                        if(belegung1.getWochentag()==Unterrichtstag.values()[j] && belegung1.getStunde()==i){
                            cell.setCellValue(belegung1.getFach().getName() + "\n" + belegung1.getLehrer().getKuerzel() + "\n" + belegung1.getRaum().getRaumNummer());
                        }
                    }
                }
            }
        }

        sheet.autoSizeColumn(4);

        try(FileOutputStream outputStream = new FileOutputStream("./data/Klasse/" + this.bezeichnung + ".xlsx")) {

            workbook.write(outputStream);

        } catch(FileNotFoundException e) {

            e.printStackTrace();

        } catch(IOException e1) {

            e1.printStackTrace();

        }


    }

    @Override
    public String toString() {
        return this.bezeichnung;
    }

}
