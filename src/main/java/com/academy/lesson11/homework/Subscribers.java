/*
2) Написать Java приложение, которое наполнит файл subscribers.xlsx, случайными данными:
	(путь к файлу взять из 'java-part.properties')
	a) Наполнить таблицу абонентов excel(2000 строк):
		- имена фамилии взять в соответстсвующих файлах (см. 'java-part.properties') со списком имен/фамилий (женских/мужских);
		- возраст генерировать случайно от 5 до 90 (можно использовать Гауссово распределение для этого диапазона)
			(диапазон брать из файла 'java-part.properties')

	b)  Телефонные номера для каждого оператора со следующими префиксами:
		- Life номера с префиксами: 38063*******, 38093*******, 38073*******
		- Kievstar номера с префиксами: 38097*******, 38067*******, 38098*******
		- Vodafone номера с префиксами: 38050*******, 38066*******, 38095*******

	Результат subscribers.xlsx должен выглядеть так:
		   1 | Васильев  | Иван | м | 23 | 380630025465 | Life
		   2 | Петрова   | Катя | ж | 34 | 380670058694 | Kievstar
		...
		2000 | Борисов   | Коля | м | 48 | 380500025465 | Vodafone
		Всего 200 случайных строк
*/

package com.academy.lesson11.homework;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Subscribers {
    public static void main(String[] args) throws IOException {
        System.out.println("Start write excel file");
        task_a(2000);
        System.out.println("Done");
    }

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

    public static void writeCell(XSSFRow row, String data, int column) {
        XSSFCell cell = row.createCell(column);
        cell.setCellValue(new String(data));
    }

    public static String makeRandomPhoneNumber(String prefix) {
        Random random = new Random();
        // int randomNum = random.nextInt(max - min + 1) + min
        int randomNum = random.nextInt(10000000 - 1000000 + 1) + 1000000;
        return  prefix + Integer.toString(randomNum);
    }

    public static void task_a(int rows_count) throws IOException {

        try {
            File file = new File("d:/!!!Autotesting/auto-projects/Academy-maven/src/main/java/com/academy/lesson11/homework/java-part.properties");
            Properties prop = new Properties();
            prop.load(new FileInputStream(file));

            // 1. считать файл с м. именами - в список
            ArrayList<String> male_firstnames = read_column_file(prop.getProperty("male.firstnames"));

            // 2. считать файл с м. фамилиями - в список
            ArrayList<String> male_lastnames = read_column_file(prop.getProperty("male.lastnames"));

            // 3. считать файл с ж. именами - в список
            ArrayList<String> female_firstnames = read_column_file(prop.getProperty("female.firstnames"));

            // 4. считать файл с ж. именами - в список
            ArrayList<String> female_lastnames = read_column_file(prop.getProperty("female.lastnames"));

            // 5. открыть файл ексель для записи
            FileOutputStream fos = new FileOutputStream(new File(prop.getProperty("subscriber.exc")));
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            Random random = new Random();

            // 6. в цикле от 0 до роус_каунт:
            //            6.1 генерируем случ целое число (индекс) из дипазон 0 до число м.имен
            //            6.2 берем из списка м. имен имя с этим индексом
            //            6.3-6.8 - аналогично для остальн имен фамилий
            //            6.9 - далее генерируем возраст из диапазона
            XSSFRow headerRow = sheet.createRow(0);
            writeCell(headerRow, "#", 0);
            writeCell(headerRow, "Фамилия", 1);
            writeCell(headerRow, "Имя", 2);
            writeCell(headerRow, "Пол", 3);
            writeCell(headerRow, "Телефон", 4);
            writeCell(headerRow, "Оператор", 5);
            writeCell(headerRow, "Возраст", 6);
            ArrayList<String> mobileOperators = new ArrayList<String>(List.of("Life", "Kievstar", "Vodafone"));
            Map<String, ArrayList<String>> operatorPrefixMap  = new HashMap<String, ArrayList<String>>();
            operatorPrefixMap.put("Life", new ArrayList<String>(List.of("38063", "38093", "38073")));
            operatorPrefixMap.put("Kievstar", new ArrayList<String>(List.of("38097", "38067", "38098")));
            operatorPrefixMap.put("Vodafone", new ArrayList<String>(List.of("38050", "38066", "38095")));

            for (int i = 0; i < rows_count; ++i) {
                // int randomNum = random.nextInt(max - min + 1) + min
                XSSFRow row = sheet.createRow(i + 1);
                boolean isMale = random.nextBoolean();
                // user id
                writeCell(row, Integer.toString(i+1), 0);
                // mobile operator
                String mobileOperator = mobileOperators.get(random.nextInt(mobileOperators.size()));
                writeCell(row, mobileOperator, 5);
                // phone number
                String operatorPrefix = operatorPrefixMap.get(mobileOperator).get(random.nextInt(operatorPrefixMap.get(mobileOperator).size()));
                String phoneNumber = makeRandomPhoneNumber(operatorPrefix);
                writeCell(row, phoneNumber, 4);
                //age:
                writeCell(row, Integer.toString(i+1), 6);
                // last name, first name
                if (isMale) {
                    String male_lastname = male_lastnames.get(random.nextInt(male_lastnames.size()));
                    writeCell(row, male_lastname, 1);
                    String male_firstname = male_firstnames.get(random.nextInt(male_firstnames.size()));
                    writeCell(row, male_firstname, 2);
                    writeCell(row, "м", 3);
                }
                else {
                    String female_lastname = female_lastnames.get(random.nextInt(female_lastnames.size()));
                    writeCell(row, female_lastname, 1);
                    String female_firstname = female_firstnames.get(random.nextInt(female_firstnames.size()));
                    writeCell(row, female_firstname, 2);
                    writeCell(row, "ж", 3);
                }
            }
            workbook.write(fos);
            workbook.close();
        } finally {
        }
    }
}

