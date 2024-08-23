package orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.qa.util.TestUtil.*;
import com.qa.base.TestBase;

public class OrangeHRMLoginPage extends TestBase 
{
	// Initializing the Page Factory/Objects:
	public OrangeHRMLoginPage() 
	{
		PageFactory.initElements(getdriver(), this); // "this" means current class object. All the above variables will
		// be initialized with this driver
	}
	
	@FindBy(xpath = "//*[contains(@class,'orangehrm-login-button')]")
	WebElement LoginButton;
	
	
	@FindBy(name = "username")
	WebElement Username;
	
	@FindBy(name ="password")
	WebElement Password;
	
	@FindBy(xpath ="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement ForgotPassword;
	
	@FindBy(className="orangehrm-login-branding")
	WebElement Logo;
	
	@FindBy(xpath = "//a[@href='http://www.orangehrm.com']")
	WebElement OrangeHRMLink;
	
	String loginUrl = prop.getProperty(env + "URL");
	
	public void EnterUserName(String username)
	{
		clearAndInput(Username, "username", username);
	}

	public void EnterPassword(String password)
	{
		clearAndInput(Password,"password",password);
	}
	
	public void Clickonlogin()
	{
		clickElement(LoginButton, "Login Button");
	}
	
//	public void ClickonOrangeHRMUrl()
//	{
//		clickElement(OrangeHRMLink, "OrangeHRM bottomlink");
//	}
	
	public void clickOnForgotPassword()
	{
		clickElement(ForgotPassword, "Forgot Password?");
	}
	
	public void checkfooterURLisClickable()
	{
		waitForElementToBeClickable(OrangeHRMLink,"FooterURL");
		driver.close();
	}
	public void login(String username, String password)
	{
		navigateToLoginURL();
		EnterUserName(username);
		EnterPassword(password);
		Clickonlogin();
	}
	
	public void ForgotPassword()
	{
		clickOnForgotPassword();
	}
	
	
	public boolean verifyLogoIsPresent()
	{
		 return isElementPresent(Logo, "orangeHRM Logo");
	}
	
	
	// Navigate to login page
		public void navigateToLoginURL() {
			// clear cookie before starting
			getdriver().manage().deleteAllCookies();
			reportLog("Cleared browser cookies");

			reportLog("Login URL: " + loginUrl);
			getdriver().get(loginUrl);
		}

}
