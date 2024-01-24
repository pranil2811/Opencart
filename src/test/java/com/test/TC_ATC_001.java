package com.test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.Base;
import com.page_class.Home_Page;
import com.page_class.ProductInfo_Page;
import com.page_class.SearchResult_Page;
import com.page_class.ShoppingCart_Page;
import com.reports.ExtentReportListener;
import com.utility.Utility;

@Listeners(ExtentReportListener.class)
public class TC_ATC_001 extends Base {

	Home_Page home;
	SearchResult_Page search;
	ProductInfo_Page product;
	ShoppingCart_Page shop;

	@Test(description = "Validate adding the product to Cart from 'Product Display' Page")
	public void tc_atc_001() throws InterruptedException {

		home = new Home_Page(driver);
		search = new SearchResult_Page(driver);
		product = new ProductInfo_Page(driver);
		shop = new ShoppingCart_Page(driver);

		driver.get(url);
		Utility.maximizeWindow(driver);

		Utility.sendKeys(driver, home.searchBox, "iMac", 5);
		Utility.sendKeysAction(driver, Keys.ENTER);

		Utility.clickElement(driver, search.iMac);
		Utility.clickElement(driver, product.addTocartBtn, 10);
		Thread.sleep(2000);
		Utility.clickElement(driver, product.shoppingcartLink, 10);

		Utility.assertPageTitleEquals(driver, "Shopping Cart", 0);

	}

}
