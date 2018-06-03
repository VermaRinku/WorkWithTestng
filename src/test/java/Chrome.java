import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win 7\\eclipse-workspace\\BS\\src\\test\\resources\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.gmail.com/");
	}

}
