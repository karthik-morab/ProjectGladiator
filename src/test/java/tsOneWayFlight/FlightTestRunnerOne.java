package tsOneWayFlight;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.Base;

import flightOneWay.flightElementsOne;

public class FlightTestRunnerOne extends Base {
	@Test(dataProvider = "dp")
	public void test1(String key, String source, String destination) throws Exception // Valid source and destination
																						// invalid date
	{
		driver.get("https://www.goibibo.com/");
		if (key.equals("Valid")) {
			flightElementsOne f = new flightElementsOne(driver);
			f.setFrom(source);
			f.setTo(destination);
			f.clickSearch();
			boolean actual = f.errorStatus1();
			Assert.assertTrue(actual);
			System.out.println("Please enter a valid departure date");
		} else if (key.equals("Insource")) // Invalid source and valid destination
		{
			flightElementsOne f = new flightElementsOne(driver);
			f.setFrom(source);
			f.setTo(destination);
			f.clickSearch();
			boolean actual = f.errorStatus1();
			Assert.assertTrue(actual);
			System.out.println("Please enter a valid Source");
		}

		else if (key.equals("Indest")) { // Valid source and invalid destination
			flightElementsOne f = new flightElementsOne(driver);
			f.setFrom(source);
			f.setTo(destination);
			f.clickSearch();
			boolean actual = f.errorStatus1();
			Assert.assertTrue(actual);
			System.out.println("Please enter a valid Destination");
		} else if (key.equals("Vdate")) {
			flightElementsOne f = new flightElementsOne(driver);
			f.setFrom(source);
			f.setTo(destination);
			f.clickDate();
			f.clickSearch();
			System.out.println("Valid date");
		}
	}

	@DataProvider
	public Object[][] dp() throws Exception {
		int row = 10;
		int col = 3;
		Object data[][] = new Object[row][col];
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("src\\test\\resources\\Utilities\\Final.xlsx"));
		XSSFSheet sh = wb.getSheet("Sheet1");
		for (int i = 0; i < row; i++) {
			data[i][0] = sh.getRow(i + 1).getCell(0).toString();
			data[i][1] = sh.getRow(i + 1).getCell(1).toString();
			data[i][2] = sh.getRow(i + 1).getCell(2).toString();
		}
		return data;
	}
}