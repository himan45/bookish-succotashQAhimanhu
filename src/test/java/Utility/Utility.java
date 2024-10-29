package Utility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v127.page.model.Screenshot;

public class Utility {

public static String generateemailwithtimestamp() {
	
Date date = new Date();
String timestamp = date.toString().replace("","_").replace(":","_");
return "himan"+timestamp+"@gmail.com";
}
public <File, TakesScreenshot> void captureScreenshot (WebDriver driver,String testname) {
	
	//File srcScreenshot =(File)driver).ScreenshotAs(OutputType.FILE);
}

}
