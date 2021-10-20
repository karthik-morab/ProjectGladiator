package flightOneWay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class flightElementsOne {

	WebDriver driver;

	public flightElementsOne(WebDriver driver) {
		this.driver = driver;
	}

	By e_from = By.xpath("//input[@id='gosuggest_inputSrc']");
	By e_to = By.xpath("//input[@id='gosuggest_inputDest']");
	By e_search = By.xpath("//button[normalize-space()='SEARCH']");
	By e_date = By.xpath("//*[@id=\"fare_20211029\"]");
	By e_pass = By.xpath("//*[@id=\"pax_link_common\"]");
	By e_adult = By.xpath("//*[@id=\"adultPaxPlus\"]");
	By e_infant = By.xpath("//*[@id=\"infantPaxPlus\"]");
	By e_error1 = By.xpath("//*[@id=\"searchWidgetCommon\"]/div[2]/div[2]/span/span");// Invalid source destination and
																						// date
	By e_error2 = By.xpath("//*[@id=\"pax_link_common\"]/div/div[1]/span/span");// Invalid infant

	public void setFrom(String from) {
		driver.findElement(e_from).clear();
		driver.findElement(e_from).sendKeys(from);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_from).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_from).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(e_from).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void setTo(String to) {
		driver.findElement(e_to).clear();
		driver.findElement(e_to).sendKeys(to);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_to).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_to).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(e_to).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void clickSearch() throws Exception {
		driver.findElement(e_search).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// WebDriverWait wait=new WebDriverWait(driver, 1500);
	}

	public void clickDate() throws Exception {
		driver.findElement(e_date).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// WebDriverWait wait=new WebDriverWait(driver, 1500);
	}

	public void clickPass() throws Exception {
		driver.findElement(e_pass).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// WebDriverWait wait=new WebDriverWait(driver, 1500);
	}

	public void clickAdult() throws Exception {
		driver.findElement(e_adult).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// WebDriverWait wait=new WebDriverWait(driver, 1500);
	}

	public void clickInfant() throws Exception {
		driver.findElement(e_infant).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// WebDriverWait wait=new WebDriverWait(driver, 1500);
	}

	public boolean errorStatus1() {
		String x;
		x = driver.findElement(e_error1).getText();
		if (x.contains("Please enter a valid"))
			return true;
		else {
			return false;
		}
	}

	public boolean errorStatus2() {
		String x;
		x = driver.findElement(e_error2).getText();
		if (x.contains("Number of infants cannot be more than adults"))
			return true;
		else {
			return false;
		}

	}

}