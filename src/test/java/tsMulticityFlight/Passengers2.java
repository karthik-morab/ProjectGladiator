package tsMulticityFlight;

import flightMulticity.FlightElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.*;
import com.url.*;

public class Passengers2 extends Base {

	@Test(description = "Testing with Infants more than Adults")
	public void InfantsMoreThanAdults() throws Exception {

		Url u = new Url();
		String site = u.getUrl();//get url
		driver.get(site);//visit url

		driver.manage().window().maximize();

		FlightElements e = new FlightElements(driver);
		e.select();
		e.clickPax();//click passengers
		e.setInfant(3);//select number of infants

		String actual = e.checkPassErr();//check error statements
		
		Assert.assertEquals(actual, "Number of infants cannot be more than adults");//compare error
	}

}
