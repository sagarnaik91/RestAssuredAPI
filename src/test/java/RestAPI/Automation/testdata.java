package RestAPI.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.rowset.internal.Row;

public class testdata {

	public static Object[][] testdata() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\IBMADMIN\\Documents\\Training\\Module1\\APIAutomation\\Automation\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int totalRows=sheet.getLastRowNum();
		System.out.println(totalRows);
		XSSFRow row = sheet.getRow(totalRows);
		int totalColumns=row.getLastCellNum();
		System.out.println(totalColumns);
		
		

		Object[][] data=new Object[totalRows+1][totalColumns];
		
		for(int i=0;i<totalRows+1;i++)
		{
			for(int j=0;j<totalColumns;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
