package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelReader;
import utility.MonitoringMail;

public class DataPara {

    public static ExcelReader er = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\Book1.xlsx");
	public static WebDriver driver;
	public static Properties config = new Properties() ;
	public static Properties or = new Properties();
	public static File f;
	public static FileInputStream fi;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static MonitoringMail mail = new MonitoringMail();
	public static WebDriverWait wait;
	
	
	@BeforeSuite
	public static void startup()
	{// if(driver==null)
	{
	try {
		fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
		log.debug("config File Found");
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	try {
		config.load(fi);
		log.debug("config file loaded");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	try {
	 fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");	
	 log.debug("or File Found");
	}catch (IOException e1) 
	{e1.getMessage();}
	try{
		or.load(fi);
		log.debug("Or file loaded");
	}catch(Throwable th)
	{th.getMessage();}
	

     
	if(config.getProperty("Browser").equals("firefox"))
	 {driver = new FirefoxDriver();
	 log.debug("Firefox launched");}
	else if (config.getProperty("Browser").equals("chrome"))
	{//System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		//driver= new ChromeDriver();
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\win 7\\eclipse-workspace\\WorkWithTestng\\src\\test\\resources\\executables\\chromedriver.exe");
	     driver = new ChromeDriver();
	     log.debug("chrome launched");
	} 
	
	}
	}


     @DataProvider
	public Object[][] getData()
	{  String sheet ="Book1";
	   int rowCount = er.getRowCount("fr")+1;	
	  // System.out.println("no of rows="+rowCount);
	   int colCount = er.getColumnCount("fr");
	   System.out.println("no of rows="+rowCount +"   No of col"+colCount);
	   
	   Object[][] data = new Object[rowCount][colCount];
	   for( int rowno=1; rowno<rowCount; rowno++)
	   { for(int colno=0; colno<colCount; colno++)
	   data[rowno-1][colno]= er.getCellData("fr", colno, rowno);
	   
	   }
	    
	   return data;
		
	}

	@Test (dataProvider="getData")
	public void doLogin(String userName ,String Pass)
	{   		

		driver.navigate().to(config.getProperty("testSiteUrl"));
	     log.debug("GMAIL.COM opened");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwait")), TimeUnit.SECONDS);	
         //testPath.type("UserName_id", "tractqa@gmail.com");
          wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicitwait")));
      	   //testPath.type("UserName_id", userName);
		  driver.findElement(By.id(or.getProperty("UserName_id"))).sendKeys(userName);
		  driver.findElement(By.id(or.getProperty("Next_button_id"))).click();
		  driver.findElement(By.id(or.getProperty("Password_id"))).sendKeys(Pass); 
		  driver.findElement(By.id(or.getProperty("Staycheckbox_id"))).click();
		  driver.findElement(By.id(or.getProperty("SignInButton_id"))).click();
	}
         // System.out.println("User and pass is" + userName + Pass);}

	
	@AfterSuite
	public void tearDown()
	{ driver.close();
	  log.debug("Test case exceuted successfully");
		
	}
	

}
