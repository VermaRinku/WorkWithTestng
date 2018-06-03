package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenerateLogs {
	
    public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriver driver; 
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	
	
	public static void type(String locator, String value)
	{  try {
		if(locator.endsWith("xpath"))
		driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		else if(locator.endsWith("Css"))
			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
		else if(locator.endsWith("name"))
			driver.findElement(By.name(or.getProperty(locator))).sendKeys(value);
		else if(locator.endsWith("id"))
			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
		else if(locator.endsWith("tag"))
			driver.findElement(By.tagName(or.getProperty(locator))).sendKeys(value);
		log.debug(value+"entered");}
	catch(Exception e01)
	{log.debug(e01.getMessage());
	
		e01.printStackTrace();}
	}
	
	public static void click(String locator)
	{ try {
		driver.findElement(By.id(or.getProperty(locator))).click();
		log.debug(locator+"clicked");
	}catch(Exception e02)
	{e02.printStackTrace();}
	}
	
	

	public static void main(String[] args) {
		
	if(driver==null)
	{
		
		try {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
		log.debug("config file found");
		}
		catch(FileNotFoundException e)
		{e.printStackTrace();}
		
		try {
			config.load(fis);
			log.debug("config file loaded");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		try {
		 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
		 log.debug("or file found");}
		catch(FileNotFoundException ex)
		{ex.printStackTrace();}
		
		try {
		or.load(fis);	
		log.debug("or file loaded");}
		catch(Exception e1)
		{e1.getStackTrace();}
	}
		if(config.getProperty("browser")=="firefox")
		{
			driver= new FirefoxDriver();
			log.debug("firefox launched");
		}
		
		driver.get(config.getProperty("testSiteUrl"));
		log.debug("Navigate to : "+ config.getProperty("testSiteUrl"));
		  driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwait")), TimeUnit.SECONDS);	
		  //  wait= new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicitwait")));
		    
		
		type("email", "tractqa@gmail.com");
		click("next");
		type("passwd", "Cust0mer@1999!");
		 boolean isChecked = driver.findElement(By.id("next")).isSelected();
		if(!isChecked)
		{click("next");}
		click("signIn");
	

	}

}
