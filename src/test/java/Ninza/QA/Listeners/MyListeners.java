package Ninza.QA.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.Extendsreport;

public class MyListeners implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentSpark.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);

		// Create a test in the report
		ExtentTest test = extent.createTest("My First Test", "Sample test description");

		// Log information
		test.pass("Step 1: Do something");
		test.fail("Step 2: Something went wrong");

		// Finalize the report
		extent.flush();
		System.out.println("Execution of project test start");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String TestName= result.getName();
		System.out.println(TestName+" start execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName= result.getName();
		System.out.println(TestName+" Got passed");
	}
			

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName= result.getName();
		System.out.println(TestName+" Failed testcase");
		System.out.println(result.getThrowable());
	    System.out.println("screenshot taken");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName= result.getName();
		System.out.println(TestName+" Skipped testcase");
		System.out.println(result.getThrowable());
	}	
	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" finished execution test");	

} 
}
