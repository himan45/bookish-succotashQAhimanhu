package Ninza.QA.Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Ninza.QA.Baseclass.base;

public class Search1Test extends base{
	
	public Search1Test(){
		super();
		}
		WebDriver driver;
		
		@BeforeMethod
		public void class1() {
			driver=instiallizebrowserandopenapplication(pop.getProperty("browser"));
		}
		


@AfterMethod
public void driverclose() {
driver.quit();
}
			@Test
			
			public void search() {
				driver.findElement(By.xpath("//input[@name='search']")).sendKeys("laptops");
			    driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
				
			}
			
}

	
