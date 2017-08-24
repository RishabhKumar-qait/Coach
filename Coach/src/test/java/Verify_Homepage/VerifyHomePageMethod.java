package Verify_Homepage;

import static com.jayway.restassured.RestAssured.authentication;
import static com.jayway.restassured.RestAssured.basic;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import Start_Browser.Browser;
import locators.Locators;

public class VerifyHomePageMethod {

	Browser browser = new Browser();
	Locators loc = new Locators();
	WebDriver driver = null;

	public WebDriver start_chrome() throws Exception {
		driver = this.browser.start_chrome();
		return driver;
	}

	public void verify_logo() {
		WebElement element = driver.findElement(loc.logo());
		assertEquals(true, element.isDisplayed());
		Reporter.log("Coach logo is verified");
	}

	public void verify_Account() {
		WebElement str = driver.findElement(loc.account());
		assertEquals(true, str.isDisplayed());
		Reporter.log("Account icon is verified");
	}

	public void verify_wishlist() {
		WebElement str = driver.findElement(loc.wishlist());
		assertEquals(true, str.isDisplayed());
		Reporter.log("Wishlist icon is verified.");
	}

	public WebDriver launch_url() throws InterruptedException {
		driver = this.browser.launch_url(driver);
		Reporter.log("Coach web application Url is launched");
		driver = this.browser.refresh_page(driver);
		Reporter.log("Page is Refreshed to get the actual content");
		return driver;
	}

	public void Verify_Main_menu(int i, String MenuItem) {
		String element = driver.findElement(loc.Main_menu(i)).getAttribute("href");
		authentication = basic("storefront", "coach123");
		given().expect().statusCode(200).when().get(element);
		Reporter.log(MenuItem + " Dropdown Menu is working.");
	}

	public void close_driver() {
		driver.close();
		Reporter.log("Browser is closed.");
	}

}
