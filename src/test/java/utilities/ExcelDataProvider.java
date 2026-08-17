package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "searchData")
    public Object[][] getSearchData() throws IOException {

        String filePath = "src/test/resources/testdata/TestData.xlsx";

        ExcelUtils excel = new ExcelUtils();

        // Open Excel file and SearchData sheet
        excel.openExcel(filePath, "SearchData");

        int rowCount = excel.getRowCount();
        int columnCount = excel.getColumnCount();

        // -1 because first row is the header
        Object[][] data = new Object[rowCount - 1][columnCount];

        // Start from row 1 to skip header
        for (int i = 1; i < rowCount; i++) {

            for (int j = 0; j < columnCount; j++) {

                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        excel.closeExcel();

        return data;
    }
}