package com.Base;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {
	
	public static String getBrowser1() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/credentials.property"));
		final String n = prop.getProperty("browser1");
		return n;
	}
	
	public static String getBrowser2() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/credentials.property"));
		final String n = prop.getProperty("browser2");
		return n;
	}
	
	public static String getBrowser3() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/credentials.property"));
		final String n = prop.getProperty("browser3");
		return n;
	}
	
	static public WebDriver getBrowser(String browser) throws Exception {
		
		String s1 = getBrowser1();
		String s2 = getBrowser2();
		String s3 = getBrowser3();
		
		if (browser.equals(s1)) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			return new ChromeDriver();
		}
		
		else if (browser.equals(s2)) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			return new FirefoxDriver();
		}

		else if (browser.equals(s3)) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
			return new EdgeDriver();
		}
		else return null;
	}
}
