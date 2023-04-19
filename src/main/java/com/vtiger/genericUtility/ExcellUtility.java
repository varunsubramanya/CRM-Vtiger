package com.vtiger.genericUtility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author varun
 *
 */
public class ExcellUtility {
/**
 * Method To read from excel file
 * @param sheet
 * @param row
 * @param cell
 * @return value in cell
 * @throws Throwable
 */
	public String getExcelValue(String sheet,int row,int cell) throws Throwable {
		FileInputStream fis= new FileInputStream("./Data/CommonData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
}
