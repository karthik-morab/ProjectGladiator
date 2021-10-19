package com.Base;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base {
	public WebDriver driver;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = DriverUtil.getBrowser("chrome");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
