package Ninza.QA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"top-links\"]")
	private WebElement  myaccountdropdown;
	
	@FindBy(linkText="Login")
	private WebElement Loginoption;
	
    public Homepage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
    }
    
    //Actions
    public void myaccount() {
    myaccountdropdown.click();
    }
    
    public LoginPage login() {
    Loginoption.click();
    return new LoginPage(driver);
    }
}
