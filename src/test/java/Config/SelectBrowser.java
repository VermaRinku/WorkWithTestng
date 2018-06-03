package Config;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import org.testng.annotations.BeforeMethod;

public class SelectBrowser {
	
	@DataProvider(name= "getnumericno")
	public int  getValue()
	{  int x = ((int)(Math.random()*100));
		return x;
	}
	
	 @Test(dataProvider = "getnumericno")
	public void selectBrowser()
	{ int x = 0;
		switch(x)
		{
		case 1 :
			System.out.println("Firefox");
			break;
		case 2 : 
			System.out.println("Chrome");
		    break;
	    default :	  
	    	System.out.println("phantom");
	    	break;
		}
	}
	
	
	

}
