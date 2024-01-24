package com.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.Base;
import com.page_class.NavBar_Page;
import com.page_class.Register_Page;
import com.reports.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class TC_RF_001 extends Base {

	@Test(priority = 1, description = "Register functionlity")
	public void register() {
		driver.get(url);
		driver.manage().window().maximize();
		NavBar_Page nb = new NavBar_Page(driver);
		Register_Page rp = new Register_Page(driver);
		nb.clickOnLogReg("reg");
		rp.enterCredentials();
	}

}

