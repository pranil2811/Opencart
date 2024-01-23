package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart_Page {

	public WebDriver driver;

	public ShoppingCart_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
