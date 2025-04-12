package pages.root;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.AccountLogoutPage;
import pages.AccountSuccessPage;
import pages.FooterOptions;
import pages.HeaderOptions;
import pages.HomePage;
import pages.LoginPage;
import pages.RightColumnOptions;
import utils.ElementUtilities;

public class RootPage {
	
	WebDriver driver;
	public ElementUtilities elementUtilities;
	public Properties prop;
	
	public RootPage(WebDriver driver) {
		this.driver = driver;
		elementUtilities = new ElementUtilities(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement pageHeading;
	
	@FindBy(xpath="//i[@class='fa fa-home']")
	private WebElement homeBreadCrumb;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Account']")
	private WebElement accountBreadcrumb;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement pageLevelWaring;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement pageLevelSuccessMessage;
	
	public String getPageLevelWarning() {
		return elementUtilities.getElementText(pageLevelWaring);
	}
	
	public String getPageLevelSuccessMessage() {
		return elementUtilities.getElementText(pageLevelSuccessMessage);
	}
	
	public LoginPage selectAccountBreadcrumbOptionWithoutLogin() {
		elementUtilities.clickOnElement(accountBreadcrumb);
		return new LoginPage(driver);
	}
	
	public HomePage selectHomeBreadcrumbOption() {
		elementUtilities.clickOnElement(homeBreadCrumb);
		return new HomePage(driver);
	}
	
	public String getPageHeading() {
		return elementUtilities.getElementText(pageHeading);
	}
	
	public HeaderOptions getHeaderOptions() {
		return new HeaderOptions(driver);
	}
	
	public RightColumnOptions getRightColumnOptions() {
		return new RightColumnOptions(driver);
	}
	
	public AccountSuccessPage getAccountSuccessPage() {
		return new AccountSuccessPage(driver);
	}
	
	public AccountLogoutPage getAccountLogoutPage() {
		return new AccountLogoutPage(driver);
	}
	
	public FooterOptions getFoooterOptions() {
		return new FooterOptions(driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
