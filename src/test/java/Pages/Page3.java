package Pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Page3 {
	
	
	@Test(dependsOnMethods= {"parentMethod" , "superParentMethod"}, groups="regression" )
	public void childMethod()
	{System.out.println("Child");}
	
	@Test
	public void superParentMethod()
	{System.out.println("SuperParent");}
	
	@Test(dependsOnMethods ="superParentMethod" , groups = "functional")
	public void parentMethod()
	{
		System.out.println("Parent");
		Assert.fail();
	}

}
