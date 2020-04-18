package com.weborders.DataBase;

import com.weborders.utilities.TestBase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


    public class DataBaseExcell extends TestBase {
        public static void ExcelData() throws IOException {

            XSSFWorkbook workbook;
            XSSFSheet worksheet;
            XSSFRow row;
            XSSFCell cell;
            String path = "WebOrderExcel.xlsx";

            File file = new File(path);
            file.exists();
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            XSSFWorkbook ScaleData= null;
            try {
                ScaleData = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            XSSFSheet workSheet = ScaleData.getSheet("ScaleDataSheet");
            int usedRow = workSheet.getPhysicalNumberOfRows();
            System.out.println("Total number of the Row : " + usedRow);
            int lastRow = workSheet.getLastRowNum();
            row = workSheet.getRow(3);
            cell = row.getCell(1);
            XSSFCell NestCell = workSheet.getRow(1).getCell(1);
            System.out.println("Nest Cell = " + NestCell);

            for (int i = 0; i <= usedRow; i++) {
                if (workSheet.getRow(i).getCell(1).toString().equals("Smart lock")) ;
                System.out.println("Order ID = " + workSheet.getRow(i).getCell(1).toString().equals("Smart lock"));
                break;

                // String productName= workSheet.getRow(i).getCell(1).toString().equals("Smart lock");
            }


            ScaleData.close();
            inputStream.close();


        }
    }


