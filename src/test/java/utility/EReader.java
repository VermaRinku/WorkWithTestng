package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EReader {
	static String path= "C:\\Users\\win 7\\eclipse-workspace\\WorkWithTestng\\src\\test\\resources\\excel\\Book1.xlsx";
	public static XSSFSheet sheet = null;
	public static FileInputStream fi;
	public static File f;
	public static XSSFWorkbook wb;
	
 /*	public EReader(String path) throws InvalidFormatException, IOException
	{  this.path = path;
	    f = new File(path);
		fi = new FileInputStream(f);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheetAt(0);	
	}
	
	
	public int getRowCount()
	{ int count = sheet.getLastRowNum()+1;
		return  count;
		
	}
	*/
	public static void main(String[] args) throws IOException
	{ f = new File(path);
	fi = new FileInputStream(f);
	wb = new XSSFWorkbook(fi);
	sheet = wb.getSheetAt(0);	
    int t= wb.getSheetIndex("Sheet2");
     
     System.out.println(t);
	}

}
