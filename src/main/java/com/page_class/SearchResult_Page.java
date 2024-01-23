package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult_Page {

	public WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'iMac')]")
	public WebElement iMac;

	public SearchResult_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	

}
