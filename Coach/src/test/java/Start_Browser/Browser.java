package Start_Browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import properties_file_reader.Properties_File_Reader;

public class Browser {
	Properties_File_Reader pf = new Properties_File_Reader();

	WebDriver driver = null;

	public WebDriver start_chrome() throws Exception {
		String testng = pf.reader();
		String maven = System.getProperty("browser");
		if (maven == null) {
			Browser(testng);

		} else {
			System.out.println("maven " + maven);
			Browser(maven);
		}
		return driver;
	}

	public WebDriver Browser(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("HtmlUnitDriver")) {
			driver = new HtmlUnitDriver();
		} else if (browser.equalsIgnoreCase("Phantomjs")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability("takesScreenshot", true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"D:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			driver = new PhantomJSDriver(caps);
		}

		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Browser is not correct");
			throw new Exception("Browser is not correct");

		}
		Reporter.log(browser + " is startted...");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver launch_url(WebDriver driver) throws InterruptedException {
		driver.get("https://storefront:coach123@dwlp2.coach.com/");
		return driver;
	}

	public WebDriver refresh_page(WebDriver driver) {
		driver.get("https://dwlp2.coach.com");
		return driver;
	}

}
