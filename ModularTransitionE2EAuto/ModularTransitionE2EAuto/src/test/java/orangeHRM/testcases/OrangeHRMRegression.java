package orangeHRM.testcases;

import static com.qa.util.TestUtil.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.JsonReader;
import com.qa.util.TestUtil;

import orangeHRM.pages.OrangeHRMDashboardPage;
import orangeHRM.pages.OrangeHRMLoginPage;
import orangeHRM.pages.OrangeHRMResetPage;

public class OrangeHRMRegression extends TestBase
{
	// Declare all pages to be used
	OrangeHRMLoginPage OrangeHRMLoginPageObj;
	OrangeHRMDashboardPage OrangeHRMDashboardPageObj;
	OrangeHRMResetPage OrangeHRMResetPageObj;

	
	// declare testdata
	String username;
	String password;
	
	
	@BeforeClass(alwaysRun = true)
	public void intialize() throws MalformedURLException
	{
		className = this.getClass().getSimpleName();
		// initialize browser
		initialization();
		// initialize testdata JSON object
		testDataFile = JsonReader.getTestDataJSON(className);
		testDataEnv = testDataFile.getJSONObject(env);
		testData = testDataEnv.getJSONObject(browserName);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setup() 
	{
		// Initilize page Objects 
		
		OrangeHRMLoginPageObj = new OrangeHRMLoginPage();
		OrangeHRMDashboardPageObj = new OrangeHRMDashboardPage();
		OrangeHRMResetPageObj = new OrangeHRMResetPage();
		
		// initialize testdata variables
		username = testData.getString("Username");
		password= testData.getString("Password");
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenshotInCaseOfFailure(ITestResult result) throws Exception {
		// Check if the test case failed or was skipped and take screenshot
		if (result.getStatus() == result.FAILURE || result.getStatus() == result.SKIP) {
			if (result.getStatus() == result.FAILURE)
				reportLog("TEST FAILED: " + result.getName());
			else
				reportLog("TEST SKIPPED: " + result.getName());
			String screenshotPath = getScreenshot(getdriver(), result.getName());
			result.setAttribute("screenshotPath", screenshotPath); // sets the value the variable/attribute
			// screenshotPath as the path of the screenshot
		} else if (result.getStatus() == result.SUCCESS) {
			reportLog("TEST PASSED: " + result.getName());
		}
	}
	
//	@AfterClass(alwaysRun = true)
	public void cleanup() {
		reportLog("Quitting browser");
		getdriver().quit();
		reportLog("Clearing threadlocal");
		unload();
	}
	
	@Test
	public void verifyLogin()
	{
		OrangeHRMLoginPageObj.login(username,password);
		threadMethod(5000);
		OrangeHRMDashboardPageObj.logout();
		
	}
	
	@Test
	public void verifyLogo()
	{
		OrangeHRMLoginPageObj.navigateToLoginURL();
		assertTrue(OrangeHRMLoginPageObj.verifyLogoIsPresent());
	}
	
	@Test
	public void verifyForgotPassword()
	{	
		OrangeHRMLoginPageObj.navigateToLoginURL();
		OrangeHRMLoginPageObj.clickOnForgotPassword();
		assertEquals(OrangeHRMResetPageObj.getResetButtonText(),"Reset Password");
		OrangeHRMResetPageObj.getBackToLoginPage();
	}
	
	@Test
	public void verifyOrangeHRMfooterUrl()
	{
		OrangeHRMLoginPageObj.navigateToLoginURL();
		OrangeHRMLoginPageObj.checkfooterURLisClickable();
	}
//	@Test(groups="name")
//	public void verifyName()
//	{
//		System.out.println("name");
//	}
}

