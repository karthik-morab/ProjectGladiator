package hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HybridDataProvider {

	WebDriver driver;

public HybridDataProvider(WebDriver driver) {
this.driver = driver;
}

	By e_hotel = By.linkText("Hotels");
	By e_loc = By.id("downshift-1-input");
	By e_daten = By.cssSelector(
			"div[data-testid='openCheckinCalendar'] h4[class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-7 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-14 hAEfdZ kSflmU']");
	By e_in1 = By.xpath(
			"//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/section/div/div[1]/div[2]/div/ul[2]/li[33]/span");
	By e_in2 = By.xpath(
			"//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/section/div/div[1]/div[2]/div/ul[2]/li[34]/span");
	By e_search = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/button");

	public void clickHotel() {
		driver.findElement(e_hotel).click(); // for opening hotels page
	}

	public void setLocation(String loca) throws Exception {
		driver.findElement(e_loc).sendKeys(loca);
		Thread.sleep(1000); // for setting the location
		driver.findElement(e_loc).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(e_loc).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	public void setLocationIn(String loca) throws Exception {
		driver.findElement(e_loc).sendKeys(loca);
		Thread.sleep(1000); // for setting the location
	}

	public void clickDate() {
		driver.findElement(e_daten).click(); // for clicking on date button
	}

	public void enterCheckInDate() {
		driver.findElement(e_in1).click();
		driver.findElement(e_in2).click();// for selecting check-in date
	}

	public void clickSearch() {
		driver.findElement(e_search).click(); // for clicking on date button
	}

}