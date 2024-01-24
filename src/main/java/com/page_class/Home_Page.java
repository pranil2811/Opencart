package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public WebDriver driver;

	@FindBy(xpath = "//input[@name='search']")
	public WebElement searchBox;
	
	@FindBy(xpath = "/html/body/header/div/div/div[2]/div/button")
	public WebElement searchBtn;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

}
