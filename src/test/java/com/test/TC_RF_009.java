package com.test;

import java.time.Duration;

import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.NavBar_Page;
import com.page_class.Register_Page;

public class TC_RF_009 extends Base {
	
	@Test(priority=1,description = "Duplicate credentials")
	public void register() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		NavBar_Page nb = new NavBar_Page(driver);
		Register_Page rp = new Register_Page(driver);
		nb.clickOnLogReg("register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		rp.duplicate_cread();
	}

}
