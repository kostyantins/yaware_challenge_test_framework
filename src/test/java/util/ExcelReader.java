package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public final class ExcelReader {

    private ExcelReader() {
    }

    public static String[][] getExcelData(final String excelFileName,
                                          final String sheetName) throws IOException {

        final FileInputStream fileSystem = new FileInputStream(excelFileName);
        final Workbook workBook = new XSSFWorkbook(fileSystem);
        final Sheet sheet = workBook.getSheet(sheetName);

        final int numberOfRows = sheet.getPhysicalNumberOfRows();
        final int numberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();

        final String[][] loginData = new String[numberOfRows - 1][numberOfCells];

        for (int i = 1; i < numberOfRows; i++) {

            for (int j = 0; j < numberOfCells; j++) {

                final Cell cell = sheet.getRow(i).getCell(j);

                switch (cell.getCellType()) {

                    case Cell.CELL_TYPE_NUMERIC:

                        loginData[i - 1][j] = String.valueOf(sheet
                                .getRow(i)
                                .getCell(j)
                                .getNumericCellValue());
                        break;

                    case Cell.CELL_TYPE_STRING:

                        loginData[i - 1][j] = sheet
                                .getRow(i)
                                .getCell(j)
                                .getStringCellValue();
                        break;
                }
            }
        }

        fileSystem.close();

        return loginData;
    }
}
