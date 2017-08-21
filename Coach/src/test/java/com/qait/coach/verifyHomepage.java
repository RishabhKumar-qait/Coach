package com.qait.coach;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyHomepage {

	WebDriver driver = null;
	// private String BROWSER = System.getProperty("browser");

	@BeforeClass

	public void start_chrome1() throws Exception {
		String browser=System.getProperty("browser");
		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:/selenium web driver/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:/selenium web driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.manage().window().maximize();


		} else if (browser.equalsIgnoreCase("in")) {

			System.setProperty("webdriver.ie.driver", "D:/selenium web driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	/*@BeforeClass
	public void start_chrome() {
		System.setProperty("webdriver.chrome.driver", "D:/selenium web driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://storefront:coach123@dwlp2.coach.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}
*/
	@BeforeTest
	private void test() {
		// TODO Auto-generated method stub

	}

	@BeforeMethod
	public void launch_url() throws InterruptedException {
		driver.get("https://dwlp2.coach.com");
		// driver.get(driver.getCurrentUrl());

	}

	@Test
	private void verify_logo() {
		// TODO Auto-generated method stub
		WebElement str = driver.findElement(By.xpath("//img[@alt='Coach Logo'][1]"));
		assertEquals(true, str.isDisplayed());
	}

	@Test
	private void verify_Account() {
		// TODO Auto-generated method stub
		WebElement str = driver.findElement(By.xpath("//a[@id='drop1']"));
		assertEquals(true, str.isDisplayed());

	}

	@Test
	private void verify_wishlist() {
		// TODO Auto-generated method stub
		WebElement str = driver.findElement(By.xpath("//span[@class='icm-icon-like']"));
		assertEquals(true, str.isDisplayed());
	}

	@AfterTest
	void close_browser() {
		driver.close();
	}

}
