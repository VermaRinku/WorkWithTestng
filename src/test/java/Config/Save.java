package Config;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Save {
	
	
	@Test
	public void test()
	{
		System.out.println("Test");
		Reporter.log("testing passed");
	}

	
	@Test
	public void testfailure()
	{ String s = "Yahoo.com";
	 String t ="Google.com";
	 Assert.assertEquals(s , t);
	 }
}
