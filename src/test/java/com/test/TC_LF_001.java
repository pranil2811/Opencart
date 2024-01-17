package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.Base;
import com.page_class.Login_Page;
import com.page_class.MyAccount_Page;
import com.page_class.NavBar_Page;

import com.reports.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class TC_LF_001 extends Base {

	private static final Logger logger = LogManager.getLogger(TC_LF_001.class);

	@Test(priority = 1, description = "Login functionality")
	public void Login() {

		driver.get(url);
		logger.info("url opened");
		driver.manage().window().maximize();
		logger.info("window maximized");

		NavBar_Page nb = new NavBar_Page(driver);
		nb.clickOnLogReg("log");
		logger.info("click on btn");

		Login_Page np = new Login_Page(driver);
		np.enterCredLogin();
		logger.info("Credentials entered ");

	}
}
