package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfo_Page {

	public WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Add to Cart')]")
	public WebElement addTocartBtn;

	@FindBy(xpath = "//a[contains(text(),'shopping cart')]")
	public WebElement shoppingcartLink;

	public ProductInfo_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
