package com.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.Base;
import com.page_class.Login_Page;
import com.page_class.MyAccount_Page;
import com.page_class.NavBar_Page;

public class TC_LF_001 extends Base {

	@Test(priority = 1, description = "Login functionality")
	public void Login() {

		driver.get(url);
		driver.manage().window().maximize();
		MyAccount_Page mp = new MyAccount_Page(driver);

		NavBar_Page nb = new NavBar_Page(driver);
		nb.clickOnLogReg("log");
		Login_Page np = new Login_Page(driver);
		np.enterCredLogin();
	}
}
