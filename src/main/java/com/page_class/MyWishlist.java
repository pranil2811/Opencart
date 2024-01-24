package com.page_class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class MyWishlist {
	
	public WebDriver driver;

	@FindBy(xpath = "//title[text()='My Wishlist']")
	public WebElement HeadingMyWishlist;
	
	@FindBy(xpath = "//a[@id='wishlist-total']")
	public WebElement whishlist;
	
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement Add_to_cart_btn;
	

	public MyWishlist(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void add_to_cart() {
		Utility.assertPageTitleEquals(driver, "My Wishlist", 20);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Utility.assertElementPresent(driver, Add_to_cart_btn, 30);
		Utility.clickElement(driver, Add_to_cart_btn, 20);
//		Utility.clickElement(driver, Add_to_cart_btn);
	}
	
}
