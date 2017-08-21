package com.qait.coach;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main_menu {
	assert_method am = new assert_method();
	WebDriver driver = null;
	@BeforeClass

	public void start_chrome() throws Exception {
		String browser=System.getProperty("browser");
		System.out.println(browser);
		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:/selenium web driver/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:/selenium web driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://storefront:coach123@dwlp2.coach.com/");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("in")) {

			System.setProperty("webdriver.ie.driver", "D:/selenium web driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		
	}
	/*@BeforeClass
	public void start_chrome() {
		System.setProperty("webdriver.chrome.driver", "D:/selenium web driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://storefront:coach123@dwlp2.coach.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		System.out.println(System.getProperty("Browser"));
	}*/

	@BeforeMethod
	public void launch_url(ITestContext ctx) throws InterruptedException {
		driver.get("https://dwlp2.coach.com");
		
		
		
		Thread.sleep(3000);
	}

	@Test
	public void dropdown_menu_new() {
		Actions action = new Actions(driver);
		
		
		
		
		WebElement element = driver.findElement(By.xpath("//a[@aria-label='New']"));
		action.moveToElement(element).build().perform();
		am.verify(driver);
	}

	@Test
	public void verify_dropdown_women() {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[@aria-label='Women']"));
		action.moveToElement(element).build().perform();
		am.verify(driver);
	}

	@Test
	public void verify_dropdown_men() {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[@aria-label='Men']"));
		action.moveToElement(element).build().perform();
		am.verify(driver);
	}

	@Test
	public void verify_dropdown_COACH_1941() {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[@data-title='COACH 1941']"));
		action.moveToElement(element).build().perform();
assertEquals(true, element.isDisplayed());
	}

	@Test
	public void verify_dropdown_Personalize() {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[@aria-label='Personalize']"));

		action.moveToElement(element).build().perform();
		am.verify(driver);
	}

	@Test
	public void verify_dropdown_sale() {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//li[@class='top-level sale']"));
		action.moveToElement(element).build().perform();
		am.verify(driver);
	}

	@Test
	public void verify_search_button() {
		
		WebElement element =driver.findElement(By.xpath("//a[@class='headerv2-search']"));
		
		assertEquals(true, element.isDisplayed());
		
	}

	@AfterClass
	private void close() {
		// TODO Auto-generated method stub
		driver.close();
	}

}
