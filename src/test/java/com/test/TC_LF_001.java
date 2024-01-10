package com.test;

import java.time.Duration;

import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.Login_Page;
import com.page_class.NavBar_Page;
import com.page_class.Register_Page;

public class TC_LF_001 extends Base {

	@Test(priority = 1, description = "Login functionality")
	public void Login() {
		Login_Page np = new Login_Page(driver);
		NavBar_Page nb = new NavBar_Page(driver);
		driver.get(url);
		driver.manage().window().maximize();
		nb.clickOnLogReg("login");
//		np.enterCredLogin();
	}
}
