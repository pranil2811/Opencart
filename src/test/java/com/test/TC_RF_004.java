package com.test;

import java.time.Duration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.Base;
import com.page_class.NavBar_Page;
import com.page_class.Register_Page;
import com.reports.CustomTestListener;

@Listeners(CustomTestListener.class)
public class TC_RF_004 extends Base {
	@Test(priority = 1, description = "Empty credentials")
	public void register() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		NavBar_Page nb = new NavBar_Page(driver);
		Register_Page rp = new Register_Page(driver);
		nb.clickOnLogReg("reg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		rp.empty_cred();
	}

}
