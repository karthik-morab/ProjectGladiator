package com.login;
import org.testng.annotations.Test;

import com.Base.Base;
import com.url.Url;


public class ArriveWebsite extends Base{
		
  @Test
  public void Test1() {
	  Url u = new Url();
	  String site = u.getUrl();
	  driver.get(site);
  }

}
