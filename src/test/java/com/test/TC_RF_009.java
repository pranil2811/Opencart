package com.test;

import java.time.Duration;

import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.Login_Page;
import com.page_class.NavBar_Page;
import com.page_class.Register_Page;

public class TC_RF_009 extends Base {
	
	@Test(priority=1,description = "Duplicate credentials")
	public void register() {
		driver.get(url);
		driver.manage().window().maximize();
		NavBar_Page nb = new NavBar_Page(driver);
		Login_Page lp = new Login_Page(driver);
		nb.clickOnLogReg("login");
		lp.enterCredLogin();
	}

}
