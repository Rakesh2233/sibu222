package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	/**
	 * This class contains reusable methods of excel file
	 *
	 */
	public class ExcelUtility {
		private Workbook workbook;
		/**
		 * This method is used to initialize the excel file
		 * @param excelPath
		 * @param sheetName
		 */
		public void initializeExcelFile(String excelPath) {
			FileInputStream fisExcel;
			try {
				fisExcel=new FileInputStream(excelPath);
				workbook=WorkbookFactory.create(fisExcel);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}
		}
		public String getDataFromExcel(int rowNumber,int cellNumber,String sheetNmae) {
			Sheet sheet = workbook.getSheet(sheetNmae);
			return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
		}
		public void closeWorkbook() {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}