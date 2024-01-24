package com.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utility.Utility;

public class Base {

	public static WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	public String browser = Utility.getPropertyDirectly("browser");
	public String url = Utility.getPropertyDirectly("url");
	private static final Logger logger = LogManager.getLogger(Base.class);

	@BeforeClass(alwaysRun = true)
	public void browserSetup() throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\browser_drivers\\chromedriver\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\browser_drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					projectPath + "\\browser_drivers\\edgedriver\\msedgedriver.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			// Add desired options, preferences, and capabilities to the EdgeOptions object
			edgeOptions.setCapability("ms:edgeOptions", "--disable-notifications"); // Example: Disable notifications
			driver = new EdgeDriver(edgeOptions);

		} else {

			throw new Exception("Invalid Browser Value");
		}
		logger.info("browser is opened");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterClass(alwaysRun = true)
	public void tearUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		logger.info("browser is closed");
	}
}
