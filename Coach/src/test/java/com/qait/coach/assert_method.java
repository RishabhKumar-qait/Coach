package com.qait.coach;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class assert_method {

	public WebDriver verify(WebDriver driver) {
		// TODO Auto-generated method stub

		assertEquals(true, driver.findElement(By.cssSelector(".active")).isDisplayed());
		return driver;
	}

}
