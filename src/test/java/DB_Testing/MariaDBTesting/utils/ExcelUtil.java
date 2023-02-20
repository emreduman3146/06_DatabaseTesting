package DB_Testing.MariaDBTesting.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class ExcelUtil {

    public static List<String> getColumnValues(String filePath, String sheetName, String columnName) {
        List<String> columnValues = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " not found in file " + filePath);
            }
            int columnIndex = -1;
            Row headerRow = sheet.getRow(0);
            Iterator<Cell> headerCellIterator = headerRow.cellIterator();
            while (headerCellIterator.hasNext()) {
                Cell headerCell = headerCellIterator.next();
                if (columnName.equals(headerCell.getStringCellValue())) {
                    columnIndex = headerCell.getColumnIndex();
                    break;
                }
            }
            if (columnIndex == -1) {
                throw new IllegalArgumentException("Column " + columnName + " not found in sheet " + sheetName);
            }
            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next(); // skip header row
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    columnValues.add(cell.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return columnValues;
    }


}




