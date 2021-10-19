package flightOneWay;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class flightElements {

	WebDriver driver;

	public flightElements(WebDriver driver) {
		this.driver = driver;
	}

	By e_from = By.xpath("//*[@id='gosuggest_inputSrc']");
	By e_to = By.xpath("//input[@id='gosuggest_inputDest']");
	By e_search = By.xpath("//button[normalize-space()='SEARCH']");
	By e_dep = By.xpath("//div[@aria-label='Tue Oct 19 2021']");
	By e_pax = By.xpath("//div[@id='pax_link_common']");
	By e_adult = By.xpath("//button[@id='adultPaxPlus']");
	By e_child = By.xpath("//button[@id='childPaxPlus']");
	By e_infant = By.xpath("//button[@id='infantPaxPlus']");
	By e_proceed = By.xpath("//button[normalize-space()='Proceed']");
	By e_book = By.xpath("//*[contains(text(), 'BOOK')]");
	By e_flightErrStatus = By.xpath("//span[@class='status_cont red ico13']");
	By e_risk = By.cssSelector(
			".dweb-commonstyles__ButtonBase-sc-13fxsy5-4.dweb-commonstyles__InsuranceButton-sc-13fxsy5-5.dweb-commonstyles__InsuranceUnselectButton-sc-13fxsy5-7.ggCItP.NqvXb.jpQHoV");
	By e_name = By.xpath("//input[@placeholder='First & Middle Name']");
	By e_mail = By.xpath("//input[@placeholder='Email']");
	By e_num = By.xpath("//input[@placeholder='Mobile No']");
	By e_pay = By.xpath("//button[normalize-space()='Proceed To Payment']");
	By e_err1 = By.xpath("//div[contains(text(),'Please make sure you enter the Name as per your go')]");
	By e_err2 = By.xpath("//span[normalize-space()='First & Middle Name is mandatory']");
	By e_err3 = By.xpath("//div[normalize-space()='Title is mandatory']");
	By e_err4 = By.xpath("//span[normalize-space()='Email ID cannot be empty']");
	By e_err5 = By.xpath("//span[normalize-space()='Please enter a valid Email ID']");
	By e_err6 = By.xpath("//span[normalize-space()='Mobile Number cannot be empty']");
	By e_err7 = By.xpath("//span[@class='red width100 padT3']");
	By e_visible = By.xpath("//span[@class='alertText padL5']//strong[contains(text(),'NOTE:')]");
	By e_err8 = By.xpath("//span[@class='status_cont']");

	public void setFrom() throws Exception {
		 
		FileInputStream fil=new FileInputStream(new File("src\\test\\resources\\Utilities\\Credentials_flights_hotels.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fil);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int count=sheet.getLastRowNum();
		System.out.println("count:"+count);
		for (int i = 1; i<=count; i++) {
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell1 = row.getCell(0);
		XSSFCell cell2 = row.getCell(1);
		driver.findElement(e_from).sendKeys(cell1.toString());
		driver.findElement(e_to).sendKeys(cell2.toString());
		driver.findElement(e_from).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(e_from).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(e_from).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(e_from).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_from).clear();
		driver.findElement(e_from).click();
		
		driver.findElement(e_to).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(e_to).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(e_to).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(e_to).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_to).clear();
		driver.findElement(e_to).click();
		}
		
	}
	public void clear()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_from).clear();
		
	}

	public void setTo(List<String> to) throws InterruptedException {
		for(int i=0;i<to.size();i++) {
			
			System.out.println(i+" "+to.get(i));
			
			driver.findElement(e_to).sendKeys(to.get(i));
			driver.findElement(e_to).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(e_to).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(e_to).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(e_to).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(e_to).clear();
			driver.findElement(e_to).click();

		  }
		
	}

	public void clickSearch() throws Exception {
		driver.findElement(e_search).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebDriverWait wait=new WebDriverWait(driver, 1500);
	}

	public String errStatus() {
		String n = driver.findElement(e_flightErrStatus).getText();
		return n;
	}

	public void setDep() {
		driver.findElement(e_dep).click();
	}

	public void clickPax() {
		driver.findElement(e_pax).click();
	}

	public void setAdult(int num) {
		for (int i = 0; i < (num); i++) {
			driver.findElement(e_adult).click();
		}
	}

	public void setChild(int num) {
		for (int i = 0; i < (num); i++) {
			driver.findElement(e_child).click();
		}
	}

	public void setInfant(int num) {
		for (int i = 0; i < (num); i++) {
			driver.findElement(e_infant).click();
		}
	}

	public void clickProceed() {
		driver.findElement(e_proceed).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// span[normalize-space()='Base Fare']
	public void clickBook() {
		driver.findElement(e_book).click();
	}

	public void clickIRisk() {
		driver.findElement(e_risk).click();
	}

	public void setName(String name) {
		driver.findElement(e_name).sendKeys(name);
	}

	public void selectTitle(String tt) {
		WebElement E_titledd = driver
				.findElement(By.xpath("//select[@class='common-elementsstyles__CustSelectTrvl-sc-ilw4bs-9 guWPd']"));
		Select s1 = new Select(E_titledd);
		s1.selectByVisibleText(tt);
	}

	public void setMail(String mail) {
		driver.findElement(e_mail).clear();
		driver.findElement(e_mail).sendKeys(mail);
		
	}

	public void setNum(String num) {
		driver.findElement(e_num).clear();
		driver.findElement(e_num).sendKeys(num);
	}

	public void clickPtopay() {
		driver.findElement(e_pay).click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public boolean checkErr1() {
		boolean x;
		x = driver
				.findElement(e_err1)
				.isDisplayed();
		
		return x;
	}
	
	public boolean checkErr2() {
		boolean x;
		x = driver.findElement(e_err2)
		.isDisplayed();
		return x;
	}
	
	public boolean checkErr3() {
		boolean x;
		x = driver.findElement(e_err3)
		.isDisplayed();
		return x;
	}
	
	public boolean checkErr4() {
		boolean x;
		x = driver.findElement(e_err4)
		.isDisplayed();
		return x;
	}
	
	public boolean checkErr5() {
		boolean x;
		x = driver.findElement(e_err5)
		.isDisplayed();
		return x;
	}
	
	public boolean checkErr6() {
		boolean x;
		x = driver.findElement(e_err6)
		.isDisplayed();
		return x;
	}
	
	public String checkErr7() {
		String x;
		x = driver.findElement(e_err7)
		.getText();
		return x;
	}
	
	public boolean checkVisible() {
		boolean x;
		x = driver.findElement(e_visible)
		.isDisplayed();
		return x;
	}
	
	public String checkErr8() {
		String x;
		x = driver.findElement(e_err8)
		.getText();
		return x;
	}
}
