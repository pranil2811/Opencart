package com.page_class;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class ShoppingCart_Page {

	public WebDriver driver;
	
	@FindBy(xpath = "//title[text()='Shopping Cart']")
	public WebElement HeadingShoppingCart;

	@FindBy(xpath = "//a[@title='Shopping Cart']")
	public WebElement shoping_cart_btn;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-inverse btn-block dropdown-toggle']")
	public WebElement shoping_value_btn;
	
	
	@FindBy(xpath = "//input[@value='1']")
	public WebElement quantity;

	public ShoppingCart_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void validate_shopping_cart() {
		Utility.clickElement(driver, shoping_cart_btn, 10);
		Utility.assertPageTitleEquals(driver, "Shopping Cart", 10);
		Utility.assertElementPresent(driver, shoping_value_btn, 10);
		String shopping_btn_text = shoping_value_btn.getText();
		Utility.assertElementPresent(driver, quantity, 5);
		assertNotEquals(shopping_btn_text, " 0 item(s) - $0.00");
	}
	

}
