package Pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {
	
	@BeforeTest
	public void createDbCon()
	{System.out.println("Create con");}
	
	@AfterTest
	public void terminateDbCon()
	{System.out.println("remove con");
		
	}
	
	
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("Launch browser");
	}
	
     @Test(priority=2 , groups= {"bvt" , "regression"})
	public void login()
	{System.out.println("doLogin");	}
     
     @Test(priority=1)
     public void registration()
     {System.out.println("register");
    	 //Assert.fail();
     }

     @AfterMethod
     public void closeBrowser()
     {
    	 System.out.println("Closing the browser");
     }
     
}
