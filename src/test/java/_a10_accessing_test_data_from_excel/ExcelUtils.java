package _a10_accessing_test_data_from_excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String excelPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		
		//Create Reference of workbook
		workbook = new XSSFWorkbook(excelPath);

		//Create Reference of worksheet
		sheet = workbook.getSheet(sheetName);
	}

	public static int getRowCount() throws IOException {
		int rowCount=0;
		//Call row count function
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows: "+rowCount);
		return rowCount;
	}
	
	public static int getColumnCount() throws IOException {
		int columnCount;
		//Call row count function
		columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No of column: "+columnCount);
		return columnCount;
	}

	public static String getCellDataString(int rowNum, int colNum) throws IOException {
		String cellData =null;
		//Call function to get cell data
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(cellData);
		return cellData;
	}

	public static void getCellDataNumber(int rowNum, int colNum) throws IOException {
		
		//Call function to get cell data
		String cellData	= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(cellData);
	}

}
