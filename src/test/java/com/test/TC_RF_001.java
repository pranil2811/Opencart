package com.test;

import java.time.Duration;

import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.NavBar_Page;
import com.page_class.Register_Page;

public class TC_RF_001 extends Base {
	
	@Test(priority=1,description = "Register functionlity")
	public void register() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		NavBar_Page nb = new NavBar_Page(driver);
		Register_Page rp = new Register_Page(driver);
		nb.click_on_my_ac();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		rp.enterCredentials();
	}

}
