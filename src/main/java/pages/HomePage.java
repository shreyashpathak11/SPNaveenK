package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	static Actions actions;

	public HomePage(WebDriver ldriver, WebDriverWait wait, Actions actions) {

		this.driver = ldriver;
		this.wait = wait;
		this.actions = actions;

		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	static WebElement myaccount;

	public static void myaccount() {

		actions.moveToElement(myaccount);
		myaccount.click();

	}

}
