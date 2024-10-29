package Ninza.QA.Testcase;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Ninza.QA.Baseclass.base;
import Ninza.QA.pageobjects.Registerpage;


public class Register1Test extends base {
	
	public Register1Test(){
		super();
		}
	
	WebDriver driver;
	
	@BeforeMethod
	public void register()
	{ 
		driver=instiallizebrowserandopenapplication(pop.getProperty("browser"));
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]")).click();
	    driver.findElement(By.linkText("Register")).click();
	}
	
@AfterMethod
public void driverclose() {
driver.quit();
}
	
	@Test (priority=1)
	public void Register() {
	Registerpage Registerpage =new Registerpage(driver);
	Registerpage.Enterfirstname(datapop.getProperty("firstname"));
	Registerpage.Enterlastname(datapop.getProperty("lastname"));
	Registerpage.Enterlastemail((generatetimestap()));
	Registerpage.Enterphonenumber(datapop.getProperty("phonenumber"));
	Registerpage.Enterpasword(datapop.getProperty("Password"));
	Registerpage.Enterconfirmpwd(datapop.getProperty("Confirmpassword"));
    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
    }	
	
		   	
	    
	@Test (priority=2)
	public void checkvalidation() {
		Registerpage Registerpage =new Registerpage(driver);
		Registerpage.Enterfirstname("");
		Registerpage.Enterlastname("");
		Registerpage.Enterlastemail("");
		Registerpage.Enterphonenumber("");
		Registerpage.Enterpasword("");
		Registerpage.Enterconfirmpwd("");
	    driver.findElement(By.xpath("//input [@name='newsletter' and @value='1']")).click();
	    driver.findElement(By.xpath("//input [@name='agree' and @value='1']")).click();
	    driver.findElement(By.xpath(" //*[@id=\"content\"]/form/div/div/input[2]")).click();
	    String firstnamemessageString=driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText();
		assertEquals(firstnamemessageString, "First Name must be between 1 and 32 characters!","firstname is empty");
	}
	public String generatetimestap() {
		Date date= new Date();
		String timestamp= date.toString().replace(" ","-").replace(":","_");
		return "himan"+timestamp+"@gmail.com";
	  
}
}