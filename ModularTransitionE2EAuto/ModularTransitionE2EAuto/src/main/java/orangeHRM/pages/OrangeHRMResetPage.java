package orangeHRM.pages;

import static com.qa.util.TestUtil.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class OrangeHRMResetPage extends TestBase 
{
	public OrangeHRMResetPage() 
	{
		PageFactory.initElements(getdriver(), this); // "this" means current class object. All the above variables will
		// be initialized with this driver
	}
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']")
	WebElement ResetButton;
	
	public String getResetButtonText()
	{
	  return retrieveText(ResetButton,"Reset Button");
	}
	
	public void getBackToLoginPage()
	{
		navigateBack();
	}
	
}
