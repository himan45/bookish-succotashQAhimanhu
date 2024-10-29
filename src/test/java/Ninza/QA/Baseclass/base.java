package Ninza.QA.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class base {
	WebDriver driver;
	public  Properties pop;
	public Properties datapop;
	public base() {
	pop= new Properties();
	File PropFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Ninza\\QA\\config\\config.properties");
	
	datapop = new Properties();
	File datapopfile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Ninza\\QA\\testdata\\testdata.properties");
    try {
	FileInputStream fis1= new FileInputStream(datapopfile); 
    datapop.load(fis1);
    } catch (Exception e) {
	
    	
	}	
	try {
			FileInputStream fis= new FileInputStream(PropFile);
			pop.load(fis);
		} catch (Exception e) {
			
		}	
	}
	
	
	public WebDriver instiallizebrowserandopenapplication(String browername) {
	String browsername ="Chrome";
		
		if (browsername.equalsIgnoreCase("Chrome")) {
			
			 driver= new ChromeDriver();
			
		} else if (browsername.equalsIgnoreCase("edge")) {
			
			 driver= new EdgeDriver();
		} 	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(pop.getProperty("url"));
		return driver;
	}

}
