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
import org.openqa.selenium.firefox.FirefoxDriver;

public class testPath {
	
	public static WebDriver driver;
	public static FileInputStream fi;
	public static FileInputStream fis;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	//public static Logger log = Logger.getLogger("devpinoyLogger")
    public static Logger log = Logger.getLogger("devpinoyLogger");
    
    
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
	
	
	
	
	public static void main(String[] args) throws IOException, Throwable
	{
		
		fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
		config.load(fi);
		log.debug("Config file loaded");
		
		 fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");	
		or.load(fi);
		log.debug("Or file loaded");
		
		System.out.println(testPath.config.getProperty("testSiteUrl"));
		
		
		
   /*
		
		
		
		driver = new FirefoxDriver();
		driver.navigate().to(config.getProperty("testSiteUrl"));
		log.debug("GMAIL.COM opened");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwait")), TimeUnit.SECONDS);	
	    //wait= new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicitwait")));
	    Thread.sleep(3000);
	  //  driver.findElement(By.id(or.getProperty("UserName_id"))).sendKeys("tractqa@gmail.com");
	    
		
		type("UserName_id", "tractqa@gmail.com");
		Thread.sleep(2000);
		click("Next_button_id");
		type("Password_id", "Cust0mer@1999!");
		 boolean isChecked = driver.findElement(By.xpath("Staycheckbox_xpath")).isSelected();
		if(!isChecked)
		{click("Staycheckbox_xpath");}
		click("SignInButton_id");
		
		
	

			
		*/
		
		
		}

}
