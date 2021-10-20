package hotelTS;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.Base;
import com.login.LoginKeywords;
import com.url.Url;

import hotel.HybridDataProvider;

public class HybridRunner extends Base {
	@Test
	public void Test1() {
		Url u = new Url();
		String site = u.getUrl();
		driver.get(site);
	}

	@Test(dataProvider = "dp")
	public void test1(String key, String locations) throws Exception // Valid source and destination invalid date
	{
		driver.get("https://www.goibibo.com/hotels/");
		driver.manage().window().maximize();
		if (key.equals("invalid")) {
			LoginKeywords key1=new LoginKeywords(driver);
			HybridDataProvider f = new HybridDataProvider(driver);
			f.setLocationIn(locations);
			f.clickSearch();
			System.out.println("Invalid name");
			key1.getSnap("EnterValidLoc");
			
		}

		else if (key.equals("Valid")) {
			HybridDataProvider f = new HybridDataProvider(driver);
			f.setLocation(locations);
			f.clickDate();
			f.enterCheckInDate();
			f.clickSearch();
			Thread.sleep(2000);
		}

	}

	@DataProvider
	public Object[][] dp() throws Exception {
		int row = 4;
		int col = 2;
		Object data[][] = new Object[row][col];
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("src\\test\\resources\\Utilities\\Hotls1.xlsx"));
		XSSFSheet sh = wb.getSheet("Sheet1");
		for (int i = 0; i < row; i++) {
			data[i][0] = sh.getRow(i + 1).getCell(0).toString();
			data[i][1] = sh.getRow(i + 1).getCell(1).toString();
		}
		return data;
	}
}