package com.compatibility;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.Test;

import com.Base.Base;
import com.Base.DriverUtil;

public class CompatibilityTestRunner extends Base {

	@Test(priority = 1)
	public void chromeBrowser() {
		driver.get("https://www.goibibo.com/");
		assertEquals(driver.getTitle(),
				"Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off");
		System.out.println("Website was Successfully launched on chrome browser");
		driver.close();
	}

	@Test(priority = 2)
	public void firefoxBrowser() throws Exception {
		driver = DriverUtil.getBrowser("firefox");
		driver.get("https://www.goibibo.com/");
		assertEquals(driver.getTitle(),
				"Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off");
		System.out.println("Website was Successfully launched on firefox browser");
		driver.close();
	}

	@Test(priority = 3)
	public void edgeBrowser() throws Exception {
		driver = DriverUtil.getBrowser("edge");
		driver.get("https://www.goibibo.com/");
		assertEquals(driver.getTitle(),
				"Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off");
		System.out.println("Website was Successfully launched on edge browser");
	}
}