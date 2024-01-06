package testP;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import driversP.Drivers;
import pages.HomePage;

public class SecondTest extends Drivers {

	@Test
	void t2() {

		System.out.println("2");
		eTest = reports.createTest("Second Test", "Clicking on My Account Button");
		eTest.log(Status.INFO, "Launching Browser");
		HomePage.myaccount();
		eTest.pass("My Account is Clicked");
		System.out.println(reports.hashCode());
	}
}
