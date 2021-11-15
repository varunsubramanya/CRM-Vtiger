package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.BaseClass;
@Listeners(com.vtiger.genericUtility.ListnerImpl.class)
public class Lisnet extends BaseClass{
@Test
public void listner() {
	
	System.out.println("screenshot");
	Assert.fail();
}
}
