package Pages;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Page2 {
	
	@Test(priority=2 , groups= "bvt")
	public void validateTitleTest()
	{  try {
		String expectedTitle = "gmail.com";
		String actualTitle = "google.com";
		
		Assert.assertEquals(expectedTitle , actualTitle);}
	 catch (Throwable t)
	{ Reporter.log("schreenshot");
	Reporter.log("case failed");
	Assert.fail(t.getMessage());
		
	}}
		
		@Test(priority=1)
		public void zest()
		{//Assert.assertTrue(isElementPresent("xpath");
		Assert.fail("FORCEFULLY FAILED");
		}
		
		@Test(priority=1 , groups= "bvt")
		public void testSkipCondition()
		{ throw new SkipException("Condition not met");
		//Reporter.log("skipped");
			
		}


}
