package com.page_class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class NavBar_Page {

	public WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement MyAccount;

	@FindBy(xpath = "//a[text()='Register']")
	public WebElement Register;

	@FindBy(xpath = "//a[text()='Login']")
	public WebElement Login;

	public NavBar_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnLogReg(String elementName) {

		MyAccount.click();
		Utility.clickElement(driver, MyAccount, 10);

		switch (elementName.toLowerCase()) {
		case "register":
//			Register.click();
			Utility.clickElement(driver, MyAccount, 10);

			break;
		case "login":
//			Login.click();
			Utility.clickElement(driver, MyAccount, 10);

			break;
		// Add more cases for other elements if needed
		default:
			System.out.println("Unknown element: " + elementName);
			// You can choose to throw an exception or handle it as needed
		}
	}

}
