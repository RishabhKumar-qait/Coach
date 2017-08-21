package com.qait.coach;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	WebDriver driver=null;
	@BeforeClass
	public void start_chrome() {
		System.setProperty("webdriver.chrome.driver", "D:/selenium web driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://storefront:coach123@dwlp2.coach.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@BeforeTest
	private void test() {
		// TODO Auto-generated method stub

	}

	@BeforeMethod
	public void launch_url() throws InterruptedException {
		driver.get("https://dwlp2.coach.com");
		// driver.get(driver.getCurrentUrl());

	}
}
