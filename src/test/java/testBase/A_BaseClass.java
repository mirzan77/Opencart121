// http://10.199.85.238:4444
// http://localhost:4444

package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class A_BaseClass {

	public static WebDriver driver;

	public Logger logger;

	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		// loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());
		
		

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("windows")) {

				capabilities.setPlatform(Platform.WIN11);
			}

			else if (os.equalsIgnoreCase("mac")) {

				capabilities.setPlatform(Platform.MAC);
			}

			else {

				System.out.println("no matching os..");
				return;
			}

			/*
			 * 
			 * if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			 * 
			 * if (br.equalsIgnoreCase("chrome")) { ChromeOptions options = new
			 * ChromeOptions(); options.setPlatformName(os); // "Windows" / "Linux" / "MAC"
			 * driver = new RemoteWebDriver(new URL("http://10.199.85.238:4444"), options);
			 * 
			 * } else if (br.equalsIgnoreCase("firefox")) { FirefoxOptions options = new
			 * FirefoxOptions(); options.setPlatformName(os); driver = new
			 * RemoteWebDriver(new URL("http://10.199.85.238:4444"), options);
			 * 
			 * } else if (br.equalsIgnoreCase("edge")) { EdgeOptions options = new
			 * EdgeOptions(); options.setPlatformName(os); driver = new RemoteWebDriver(new
			 * URL("http://10.199.85.238:4444"), options);
			 * 
			 * } else { throw new IllegalArgumentException("Invalid browser name: " + br); }
			 * }
			 * 
			 */
			

			// browser

			switch (br.toLowerCase()) {

			case "chrome":
				capabilities.setBrowserName("chrome");
				break;

			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;

			case "firefox":
				capabilities.setBrowserName("firefox");
				break;

			default:
				System.out.println("Invalid browser name...");
				return;
			}

			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),capabilities);

		}

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			case "firefox":
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("Invalid browser name...");
				return;
			}

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	
	  @AfterClass(groups = { "Sanity", "Regression", "Master" }) 
	  public void tearDown() {
	  
	  driver.quit(); }
	 
	
	/*
	 * @AfterMethod(alwaysRun = true,groups = { "Sanity", "Regression", "Master" })
	 * public void tearDown() { if (driver != null) { driver.quit(); } }
	 */


	public String randomString() {

		String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {

		String generatedString = RandomStringUtils.secure().nextNumeric(10);
		return generatedString;
	}

	public String randomAlphaNumeric() {

		String generatedString = RandomStringUtils.secure().nextAlphanumeric(10);
		return generatedString;
	}

	public String captureScreen(String tname) throws IOException {

		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

}
