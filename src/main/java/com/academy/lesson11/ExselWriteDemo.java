package com.academy.lesson11;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExselWriteDemo {
    public static void main(String[] args) throws IOException {
        String pathFrom = "d:\\!!!Autotesting\\telesens\\lesson11\\мужские имена.txt";
        BufferedReader br1 = new BufferedReader(new FileReader(pathFrom));
        String pathOut = "d:\\!!!Autotesting\\telesens\\lesson11\\exsel-names.xlsx";
        FileOutputStream fos = new FileOutputStream(new File(pathOut));
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Налним данными
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Ашот");

        // Физически запись в файл



        br1.lines()
                .limit(10)
                .peek(s->writeNameToExcell(s, sheet))
                .forEach(System.out::println);

        workbook.write(fos);

    }

    public static void writeNameToExcell(String  name, XSSFSheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        XSSFRow row = sheet.createRow(lastRowNum + 1);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(name);

    }
}
