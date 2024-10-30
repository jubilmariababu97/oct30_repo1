package test;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.SauceDemoInventoryPage;
import pages.SauceDemoLoginPage;
import util.ExcelUtil;

public class SauceDemoLoginTest extends TestBase{

	SauceDemoLoginPage loginPage;
	

	@Test(dataProvider= "tempTestData")
   public void loginTest(String userId, String pwd) throws InterruptedException
	{
		Thread.sleep(3000);
		
	loginPage = new SauceDemoLoginPage(driver);
		
		//Should fetch the username and password from external test data files
		SauceDemoInventoryPage inventoryPage = loginPage.login(userId, pwd);
		System.out.println(userId + " - " + pwd);
		String expectedProductLabel = "PRODUCTS";
		String actualProductLabel = inventoryPage.getProductLabel();
		
		
		Assert.assertEquals(expectedProductLabel, actualProductLabel);
	}
	
	@DataProvider(name = "tempTestData")
	public Object[][] tempTestData() throws Exception {

		String[][] testData = ExcelUtil.getExcelDataIn2DArray(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\loginTestData.xlsx", "loginSheet");
		return testData;
	}
	
	


}