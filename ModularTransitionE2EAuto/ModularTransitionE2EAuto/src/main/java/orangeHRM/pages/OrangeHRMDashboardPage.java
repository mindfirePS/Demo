package orangeHRM.pages;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import static com.qa.util.TestUtil.*;
//import com.qa.base.TestBase;
//import org.openqa.selenium.support.PageFactory;

import static com.qa.util.TestUtil.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class OrangeHRMDashboardPage extends TestBase
{
	
	
	@FindBy(xpath = "//button[@class='oxd-glass-button orangehrm-upgrade-button']")
	WebElement UpgradeButton;
	
	@FindBy(xpath = "//li[@class='oxd-userdropdown']")
	WebElement UserButton;
	
	@FindBy(xpath = "//button[@class='oxd-icon-button']")
	WebElement HelpButton;
	
	@FindBy(xpath = "//div[@class='oxd-main-menu-search']")
	WebElement SearchButton;
	
	@FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
	WebElement MenuArrowButton;
	
	@FindBy(xpath = "//a[@Class='oxd-main-menu-item active toggle']")
	WebElement MenuHomeButton;
	
	@FindBy(xpath = "//button[@Class='oxd-icon-button oxd-icon-button--danger orangehrm-report-icon']")
	WebElement PendingSelfReviewButton;
	
	@FindBy(xpath = "//i[@Class='oxd-icon bi-stopwatch']")
	WebElement TimerButton;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement LogoutButton;
	
	public OrangeHRMDashboardPage() 
	{
		PageFactory.initElements(getdriver(), this); // "this" means current class object. All the above variables will
		// be initialized with this driver
	}
	
	
	public void clickOnUserButton()
	{
		clickElement(UserButton, "User Button");
	}
	
	public void clickOnLogoutButton()
	{
		clickElement(LogoutButton, "Logout Button");
	}
	
	public void logout()
	{
		clickOnUserButton();
		//threadMethod(5000);
		clickOnLogoutButton();
		driver.close();
	}
}
