package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;

    // Open Excel file
    public void openExcel(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get total number of rows
    public int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }

    // Get total number of columns
    public int getColumnCount() {

        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    // Read cell data
    public String getCellData(int rowNum, int columnNum) {

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(
                sheet.getRow(rowNum).getCell(columnNum)
        );
    }

    // Close Excel
    public void closeExcel() throws IOException {

        if (workbook != null) {
            workbook.close();
        }
    }
}