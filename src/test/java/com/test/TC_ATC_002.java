package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.Login_Page;
import com.page_class.MyAccount_Page;
import com.page_class.MyWishlist;
import com.page_class.NavBar_Page;
import com.page_class.ShoppingCart_Page;
import com.reports.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class TC_ATC_002 extends Base {
	
	private static final Logger logger = LogManager.getLogger(TC_ATC_002.class);
	
	@Test(priority = 1, description = "Validate adding the product to Cart from 'Wish List' Page")
	public void validate_wishlist() {

		driver.get(url);
		logger.info("url opened");
		driver.manage().window().maximize();
		logger.info("window maximized");

		NavBar_Page nb = new NavBar_Page(driver);
		nb.clickOnLogReg("log");
		logger.info("click on btn");

		Login_Page np = new Login_Page(driver);
		np.enterCredLogin();
		logger.info("Login Successfull ");
		
		MyAccount_Page ac = new MyAccount_Page(driver);
		ac.wishlist();
		logger.info("Land on My Wishlist Page ");

		MyWishlist mw = new MyWishlist(driver);
		mw.add_to_cart();
		
		ShoppingCart_Page sc = new ShoppingCart_Page(driver);
		sc.validate_shopping_cart();
	}
	

}
