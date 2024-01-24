package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class MyAccount_Page {

	public WebDriver driver;

	@FindBy(xpath = "//h2[text()='My Account']")
	public WebElement HeadingMyAccount;
	
	
	@FindBy(xpath = "//a[@id='wishlist-total']")
	public WebElement whishlist;
	

	public MyAccount_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void wishlist() {
		Utility.assertPageTitleEquals(driver, "My Account", 10);
		Utility.assertElementPresent(driver, whishlist, 10);
		Utility.clickElement(driver, whishlist, 10);
		
	}
}
