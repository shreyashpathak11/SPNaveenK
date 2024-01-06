package testP;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import driversP.Drivers;
import pages.HomePage;

public class FirstTest extends Drivers {

	@Test
	void t1() {
		System.out.println("1");
		eTest = reports.createTest("First Test", "Clicking on My Account Button");
		eTest.log(Status.INFO, "Launching Browser");
		HomePage.myaccount();
		eTest.pass("My Account is Clicked");
		System.out.println(reports.hashCode());

	}

}
