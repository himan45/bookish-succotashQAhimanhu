package Ninza.QA.Testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Ninza.QA.Baseclass.base;
import Ninza.QA.pageobjects.Homepage;
import Ninza.QA.pageobjects.LoginPage;

public class loginTest extends base {
	LoginPage LoginPage;
	public loginTest(){
	super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=instiallizebrowserandopenapplication(pop.getProperty("browser"));
		Homepage homepage = new Homepage(driver);
		homepage.myaccount();
		LoginPage = homepage.login();
		 
	}
	
	@AfterMethod
	public void driverclose() {
	driver.quit();
	}

	
	@Test (priority=1)
	public void login() {
	
		LoginPage.enteremailaddress(pop.getProperty("validemail"));
		LoginPage.password1(pop.getProperty("validpassword"));
	    LoginPage.clickonloginbutton();
		
		 		}
  
@Test (priority=2)
	public void invalidcredentials() {

	
	LoginPage.enteremailaddress(Utility.Utility.generateemailwithtimestamp());
	LoginPage.password1(datapop.getProperty("invalidPassword"));
    LoginPage.clickonloginbutton();
	String Actualwarningmessage =driver.findElement(By.xpath("//*[@id=\"account-loginTest\"]/div[1]")).getText();
	String Expectedwarningmesage= datapop.getProperty("Emailpasswordnomatch");
	Assert.assertTrue(Actualwarningmessage.contains(Expectedwarningmesage),"Expected warning message is incorrect");
	    
}
		
	@Test(priority=3)
	public void invalidemailvaidpassword() {
	  
		driver.findElement(By.id("input-email")).sendKeys(Utility.Utility.generateemailwithtimestamp());
		driver.findElement(By.id("input-password")).sendKeys(pop.getProperty("validpassword"));	
		driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
		String Actualwarningmessage =driver.findElement(By.xpath("//*[@id=\"account-loginTest\"]/div[1]")).getText();
		String Expectedwarningmesage=datapop.getProperty("Emailpasswordnomatch");
		Assert.assertTrue(Actualwarningmessage.contains(Expectedwarningmesage),"Expected warning message is incorrect");
	    
	}
	    @Test(priority=4)
	    
		public void blackusernamepawword() {
	    
			driver.findElement(By.id("input-email")).sendKeys("");
			driver.findElement(By.id("input-password")).sendKeys("");	
			driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
			String Actualwarningmessage =driver.findElement(By.xpath("//*[@id=\"account-loginTest\"]/div[1]")).getText();
			String Expectedwarningmesage=datapop.getProperty("Emailpasswordnomatch");
			Assert.assertTrue(Actualwarningmessage.contains(Expectedwarningmesage),"Expected warning message is incorrect");
		    
		}
			
		}
				
		
	
	
	
	
   	
	

