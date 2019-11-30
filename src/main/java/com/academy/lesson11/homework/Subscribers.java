package com.academy.lesson11.homework;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Subscribers {
    public static void main(String[] args) throws IOException {
        String pathFrom = "d:\\!!!Autotesting\\!Telesens_Academy\\lesson11\\женские имена.txt";
        BufferedReader br1 = new BufferedReader(new FileReader(pathFrom));
        String pathTo = "d:\\!!!Autotesting\\!Telesens_Academy\\lesson11\\subscriber.xlsx";
        FileOutputStream fos = new FileOutputStream(new File(pathTo));
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);

        br1.lines()
                .limit(10)
                .peek(s -> writeNameToExcell(s, sheet))
                .forEach(System.out::println);
        workbook.write(fos);

        br1.close();
        fos.close();
        workbook.close();

    }
    public static void writeNameToExcell(String name, XSSFSheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        XSSFRow row = sheet.createRow(lastRowNum + 1);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(name);
    }
}

