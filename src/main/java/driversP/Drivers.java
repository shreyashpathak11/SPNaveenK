package driversP;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;

public class Drivers {

	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public Actions actions;
	public ExtentTest eTest;

	@BeforeSuite
	public HomePage browserRun() {

		String browser = BrowserSelect.getbrowser("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(BrowserSelect.getbrowser("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);

		HomePage hp = new HomePage(driver, wait, actions);

		return new HomePage(driver, wait, actions);

	}

	@BeforeMethod
	public void reports() {

		sparkReporter = new ExtentSparkReporter(
				"D:\\SP Main Folder\\Java\\MyJavaProjects\\cucumberTestNG\\Reports\\reports.html");
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		System.out.println(reports.hashCode());

	}

	@AfterSuite
	public void exitBrowser() {

		driver.quit();
		reports.flush();
	}

}
