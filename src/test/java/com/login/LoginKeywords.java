package com.login;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class LoginKeywords {
	WebDriver driver;

	public LoginKeywords(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getSnap(String locationWithFileName) {
		TakesScreenshot tc = (TakesScreenshot) driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(locationWithFileName + ".png"));
		} catch (Exception E) {
			System.out.println("Error with taking ScreenShot");
		}
	}
}
