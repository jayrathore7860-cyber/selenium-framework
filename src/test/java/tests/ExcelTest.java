package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.ExcelUtils;

public class ExcelTest {

    @Test
    public void readExcelData() throws IOException {

        String filePath = "src/test/resources/testdata/TestData.xlsx";

        ExcelUtils excel = new ExcelUtils();

        // Open Excel
        excel.openExcel(filePath, "SearchData");

        // Get rows and columns
        int rowCount = excel.getRowCount();
        int columnCount = excel.getColumnCount();

        System.out.println("Total Rows: " + rowCount);
        System.out.println("Total Columns: " + columnCount);

        // Read Excel data
        for (int i = 1; i < rowCount; i++) {

            for (int j = 0; j < columnCount; j++) {

                String data = excel.getCellData(i, j);

                System.out.println("Data: " + data);
            }
        }

        // Close Excel
        excel.closeExcel();
    }
}