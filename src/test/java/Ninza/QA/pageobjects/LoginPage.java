package Ninza.QA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Ninza.QA.Baseclass.base;

public class LoginPage extends base {

WebDriver driver;


 
	@FindBy(id="input-email")
	private WebElement emailaddressby;
	
	 @FindBy(id="input-password") 
	 private WebElement password;
	 
	 @FindBy(xpath="//input[@value=\"Login\"]")
	 private WebElement LoginButton;
	  

    public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
} 
    //action
    public void enteremailaddress(String emailtext) {
    emailaddressby.sendKeys(emailtext);
    }
    
    public void password1(String Passwordtext) {
    password.sendKeys(Passwordtext);
    }
    public void clickonloginbutton() {
	LoginButton.click(); 
    }

}



