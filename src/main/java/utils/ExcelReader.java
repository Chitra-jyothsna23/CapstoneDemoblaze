
package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private static final String FILE_PATH = "C:\\Users\\Jyothsna Chitra\\Desktop\\Login.xlsx";

    public static String getData(int row, int col) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_PATH);
       XSSFWorkbook workBook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workBook.getSheetAt(0);
        XSSFRow excelRow = sheet.getRow(row);
        XSSFCell cell = excelRow.getCell(col);

        String data = cell.getStringCellValue();

        // Close resources to avoid memory leaks
        workBook.close();
        fis.close();

        return data;
    }
}


