package orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.base.TestBase;

public class OrangeHRMDashboardPage extends TestBase
{
	@FindBy(xpath = "//*[@class='oxd-glass-button orangehrm-upgrade-button']")
	WebElement Upgradebutton;
	
	@FindBy(xpath = "//*[@class='oxd-userdropdown-tab']")
	WebElement Userbutton;
	
	@FindBy(xpath = "//*[@class='oxd-icon-button']")
	WebElement Helpbutton;
	
	@FindBy(xpath = "//*[@class='oxd-main-menu-search']")
	WebElement Searchbutton;
	
	@FindBy(xpath = "//*[@class='oxd-icon-button oxd-main-menu-button']")
	WebElement MenuArrowButton;
	
	@FindBy(xpath = "//*[@Class='oxd-main-menu-item active toggle']")
	WebElement MenuHomeButton;
	
	@FindBy(xpath = "//*[@Class='oxd-icon-button oxd-icon-button--danger orangehrm-report-icon']")
	WebElement PendingSelfReviewButton;
	
	@FindBy(xpath = "//*[@Class='oxd-icon-button oxd-icon-button--info orangehrm-report-icon']")
	WebElement CandidatesToInterviewButton;
	
	@FindBy(xpath = "//*[@Class='oxd-icon bi-stopwatch']")
	WebElement TimerButton;
	
	
}
