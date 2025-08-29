package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.A_BaseClass;

/**
 * ExtentReportManager:
 * Implements TestNG ITestListener to generate Extent Reports for test execution.
 * Handles test start, success, failure, skipped, and completion events.
 */
public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; // Reporter configuration
    public ExtentReports extent;              // Main Extent report object
    public ExtentTest test;                   // Test logger reference
    String repName;                           // Report file name

    @Override
    public void onStart(ITestContext testContext) {
    	
    	/*
    	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    	Date dt = new Date();
    	String currentdatetimestamp=df.format(dt);
    	*/
    	
        // Create timestamp for report file name
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timestamp + ".html";

        // Define report location
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + repName);

        // Configure report appearance
        sparkReporter.config().setDocumentTitle("Opencart Automation Report");
        sparkReporter.config().setReportName("Opencart Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReports and attach reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add environment details
        extent.setSystemInfo("Application", "Opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        // Fetch parameters from testng.xml
        String os = testContext.getCurrentXmlTest().getParameter("os");
        if (os != null) {
            extent.setSystemInfo("Operating System", os);
        }

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        if (browser != null) {
            extent.setSystemInfo("Browser", browser);
        }

        // Add included groups info
        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        // Capture screenshot and attach to report
        try {
            String imgPath = new A_BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " skipped");
        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
        // Write all test information to report
        extent.flush();

        // Auto-open the generated report in browser
        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
        File extentReport = new File(pathOfExtentReport);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
        
        
        try {
        	URL url = URI.create("file:///" + System.getProperty("user.dir") + "/reports/" + repName).toURL();

        	// Create the email message
        	ImageHtmlEmail email = new ImageHtmlEmail();
        	email.setDataSourceResolver(new DataSourceUrlResolver(url));
        	email.setHostName("smtp.googlemail.com");
        	email.setSmtpPort(465);
        	email.setAuthenticator(new DefaultAuthenticator("pavanoltraning@gmail.com", "22UJ1A6683@786m"));
        	email.setSSLOnConnect(true);
        	email.setFrom("mirzanuddin786@gmail.com"); // Sender
        	email.setSubject("Test Results");
        	email.setMsg("Please find Attached Report...");
        	email.addTo("22uj1a6683@mrem.ac.in"); // Receiver
        	email.attach(url, "extent report", "please check report...");
        	email.send(); // send the email

        	} catch (Exception e) {
        	e.printStackTrace();
        	}
        
    }
}
