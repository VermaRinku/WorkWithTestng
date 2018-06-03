package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaSriptExe {
	
	public static WebDriver driver;
	
	public static void  CaptureScreenShot()
	{   Date d = new Date();
		String fileName= d.toString().replace(":", "_").replace(" ","_")+".jpg";
		TakesScreenshot ts= (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\screenshot\\"+fileName));
		    testPath.log.debug("ScreenShot captured");
		    System.out.println("test");
		} catch (IOException e) {
			testPath.log.debug("Error while screenshot capture");
			e.printStackTrace();
			
		}
		
	}

	
	public static void main(String[] args) throws IOException
	{
		driver = new FirefoxDriver();
		driver.navigate().to("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]")) );
		//js.executeScript("alert('this is alert box!')");
		CaptureScreenShot();
		
		timeStamp();
		
		
		
		
	}
	
	
	public static void timeStamp()
	{
  Date d = new Date();
  System.out.println(d.toString().replace(":", "_").replace(" ", "_")+".jpg");
		
	}
	
}
