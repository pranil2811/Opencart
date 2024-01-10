package com.page_class;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utility.Utility;

public class Login_Page {

	WebDriver driver;

	String filepth = System.getProperty("user.dir") + "\\test_data\\excel_sheet_data\\test_data.xlsx";

	@FindBy(id = "input-email")
	public WebElement email;

	@FindBy(id = "input-password")
	public WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	public WebElement LoginBtn;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterCredLogin() {
		Utility.clickElement(driver, email);
		Utility.sendKeys(driver, email, "pranilpalse7@gmail.com", 10);
		Utility.clickElement(driver, password);
		Utility.sendKeys(driver, password, "pranil@123", 10);
		Utility.clickElement(driver, LoginBtn);
	}

	public void clickLoginBtn() {

		

	}

}
