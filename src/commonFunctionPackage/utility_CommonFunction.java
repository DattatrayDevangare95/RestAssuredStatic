package commonFunctionPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility_CommonFunction {
	public static void evidenceFilecreator(String filename, String requestBody, String responseBody) throws IOException
	{
		File newFile=new File("C:\\Users\\MIT\\Desktop\\New folder2\\" +filename + ".txt");
		System.out.println("a new text file created at to record request and response of APT : " +newFile.getName());
		
		FileWriter datawrite=new FileWriter(newFile);
		datawrite.write("request body " + requestBody + "\n\n");
		datawrite.write("responseBody : " + responseBody);
		datawrite.close();
		System.out.println("req body and res body are saved in : " + newFile.getName());
		
	}
	
	
	public static ArrayList<String> readdataexcels(String sheetname, String testcasename) throws IOException
	{
		ArrayList<String> ArrayData=new ArrayList<String>();
		//step1 create object of file input string
		FileInputStream fis=new FileInputStream("C:\\Users\\MIT\\Desktop\\New folder2\\Post_Test_Data.xlsx");
		//step2 access thew excel file
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		//step3 access the sheetname
		int countofsheet=workbook.getNumberOfSheets();
		for(int i=0; i<countofsheet;i++)
		{
			String filesheetname=workbook.getSheetName(i);
			if(filesheetname.equalsIgnoreCase(sheetname))
			{
				//step4 access the row from where data is suppose to fetch
			XSSFSheet sheet=workbook.getSheetAt(i);
			Iterator<Row>rows=sheet.iterator();
			Row r=rows.next();
			
			while(rows.hasNext())
			{
				Row r1=rows.next();
				if (r1.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					Iterator<Cell> cellvalues=r1.cellIterator();
					while(cellvalues.hasNext())
					{
						String testdata=cellvalues.next().getStringCellValue();
						ArrayData.add(testdata);
					}
				}
			}
		}
	}
	workbook.close();
	return ArrayData;
	}

}
