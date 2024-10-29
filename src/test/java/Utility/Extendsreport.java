package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extendsreport  { 
	
	public static ExtentReports generateextendreport() {
	
	ExtentReports extentreport = new ExtentReports();
	File extentReportfile =new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html" );
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportfile);
	
	sparkReporter.config().setTheme(Theme.DARK);

	extentreport.attachReporter(sparkReporter);
	Properties datapop1 = new Properties();
	File datapopfile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Ninza\\QA\\testdata\\testdata.properties");
    try {
    	FileInputStream fis2= new FileInputStream(datapopfile); 
        datapop1.load(fis2);
	} catch (Exception e) {
		e.printStackTrace();
	}

    
	extentreport.setSystemInfo("Application URL",datapop1.getProperty("url"));
	extentreport.setSystemInfo("Application URL",datapop1.getProperty("browser"));
	extentreport.setSystemInfo("Application URL",datapop1.getProperty("validemail"));
	
	return extentreport;
	}}