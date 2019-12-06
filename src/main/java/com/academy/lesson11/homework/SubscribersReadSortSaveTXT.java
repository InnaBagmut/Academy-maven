package com.academy.lesson11.homework;

import com.academy.lesson06.Gender;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class SubscribersReadSortSaveTXT {
    private Long id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private int age;
    private String phoneNumber;

    //Map<Long, Subscriber> = new
    public static void main(String[] args) throws IOException {
        // Path to properties:
        File file = new File("d:/!!!Autotesting/auto-projects/Academy-maven/src/main/java/com/academy/lesson11/homework/java-part.properties");
        Properties prop = new Properties();
        prop.load(new FileInputStream(file));
        // Read XSL file
        FileInputStream fis = new FileInputStream(prop.getProperty("subscriber.exc"));  //OR prop.getProperty("subscriber.exc"))
        Workbook workbook = new XSSFWorkbook(fis);
        // Get first sheet from the workbook
        Sheet firstSheet = workbook.getSheetAt(0);
        // Get iterator to all the rows in current sheet
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // Change to getCellType() if using POI 4.x
                CellType cellType = cell.getCellTypeEnum();

                switch (cellType) {
                    case _NONE:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("\t");
                        break;
                    case BLANK:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case FORMULA:
                        // Formula
                        System.out.print(cell.getCellFormula());
                        System.out.print("\t");

                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        // Print out value evaluated by formula
                        System.out.print(evaluator.evaluate(cell).getNumberValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        System.out.print("\t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        System.out.print("\t");
                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("\t");
                        break;
                }
            }
            System.out.println("");
        }
        workbook.close();
        fis.close();


        //ArrayList<String> male_firstnames = read_column_file(prop.getProperty("subscriber.exc"));
        //System.out.println(male_firstnames.toString());

       String pathMaleFirstnames = prop.getProperty("male.firstnames");
        BufferedReader brMaleFirstnames = new BufferedReader(new FileReader(pathMaleFirstnames));
        List<String> maleFirstnames = new ArrayList<>();
        String nextName;
        while ((nextName = brMaleFirstnames.readLine()) != null) {
            maleFirstnames.add(nextName);
        }
        System.out.println(maleFirstnames);
    }

    //HashMap.put(id, firstName)

    public static ArrayList<String> read_column_file(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> data = null;
        try {
            data = new ArrayList<String>(br.lines().collect(Collectors.toList()));
        } finally {
            br.close();
        }
        return data;
    }

    //public static XSSFWorkbookFactory readWorkbook(String prop.)


}
