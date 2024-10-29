package Ninza.QA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ninza.QA.Baseclass.base;


	public class Registerpage extends base {

		WebDriver driver;
		
		@FindBy(id="input-firstname")
		private WebElement userFirstname;
		
		@FindBy(id="input-lastname")
		private WebElement userLastname;
		
		@FindBy(id="input-email")
		private WebElement useremailid; 
		
		@FindBy(id="input-telephone")
		private WebElement usertelephone;
		
		@FindBy(id="input-password")
		private WebElement userpassword;
		
		@FindBy(id="input-confirm")
		private WebElement userconfirmpassword;
		
		
		public Registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	//	Action
		public void Enterfirstname(String firstnametext) {
		userFirstname.sendKeys(firstnametext);
		}
		public void Enterlastname(String lastnametext) {
		userLastname.sendKeys(lastnametext);
		}
		public void Enterlastemail(String emailtext) {
		useremailid.sendKeys(emailtext);
		}

		public void Enterphonenumber(String phonenumbertext) {
		usertelephone.sendKeys(phonenumbertext);
		}
	
		public void Enterpasword(String passwordtext) {
		userpassword.sendKeys(passwordtext);
		}
		public void Enterconfirmpwd(String confirmpasswordtext) {
		userconfirmpassword.sendKeys(confirmpasswordtext);
		}
		
		
}
