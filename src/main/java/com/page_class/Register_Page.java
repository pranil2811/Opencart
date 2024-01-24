package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Utility;

public class Register_Page {

	public static WebDriver driver;

//	String filepth = System.getProperty("user.dir") + "\\test_data\\excel_sheet_data\\test_data.xlsx";

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	public WebElement Heading;

	@FindBy(id = "input-firstname")
	public WebElement first_name;

	@FindBy(id = "input-lastname")
	public WebElement last_name;

	@FindBy(id = "input-email")
	public WebElement email;

	@FindBy(id = "input-password")
	public WebElement password;

	@FindBy(id = "input-newsletter")
	public WebElement Subscribe;

	@FindBy(name = "agree")
	public WebElement Privacy;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement ContinueBtn;

	@FindBy(xpath = "//a[text()='Continue']")
	public WebElement SuccussPage_ContinueBtn;

	@FindBy(id = "error-firstname")
	public WebElement errorFirstname;

	@FindBy(id = "error-lastname")
	public WebElement errorLastname;

	@FindBy(id = "error-email")
	public WebElement errorEmail;

	@FindBy(id = "error-password")
	public WebElement errorPassword;

	@FindBy(xpath = "//*[contains(text(),' Warning: E-Mail Address is already registered!')]")
	public WebElement alert;

	public Register_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterCredentials() {

		Utility.assertElementPresent(driver, first_name, 10);
		Utility.clickElement(driver, first_name, 10);
		Utility.sendKeys(driver, first_name, "aniket", 10);

		Utility.assertElementPresent(driver, last_name, 10);
		Utility.clickElement(driver, last_name, 10);
		Utility.sendKeys(driver, last_name, "patil", 10);

		Utility.assertElementPresent(driver, email, 10);
		Utility.clickElement(driver, email, 10);
		Utility.sendKeys(driver, email, "aniketpatil@gmail.com", 10);

		Utility.assertElementPresent(driver, password, 10);
		Utility.clickElement(driver, password, 10);
		Utility.sendKeys(driver, password, "aniket@123", 10);

		Utility.clickElement(driver, Privacy);
		Utility.clickElement(driver, ContinueBtn);

		Utility.assertElementPresent(driver, Heading, 10);
		Utility.assertTextEqualsByElementText(driver, Heading, "Your Account Has Been Created!", 10);

		Utility.assertElementPresent(driver, SuccussPage_ContinueBtn, 10);
		Utility.clickElement(driver, SuccussPage_ContinueBtn, 10);

	}

	public void empty_cred() {

		Utility.assertElementPresent(driver, ContinueBtn, 10);
		Utility.clickElement(driver, ContinueBtn);

		Utility.assertElementPresent(driver, errorFirstname, 10);
		Utility.assertTextEqualsByElementText(driver, errorFirstname, "First Name must be between 1 and 32 characters!",
				10);

		Utility.assertElementPresent(driver, errorLastname, 10);
		Utility.assertTextEqualsByElementText(driver, errorLastname, "Last Name must be between 1 and 32 characters!",
				10);

		Utility.assertElementPresent(driver, errorEmail, 10);
		Utility.assertTextEqualsByElementText(driver, errorEmail, "E-Mail Address does not appear to be valid!", 10);

		Utility.assertElementPresent(driver, errorPassword, 10);
		Utility.assertTextEqualsByElementText(driver, errorPassword, "Password must be between 4 and 20 characters!",
				10);

	}

	public void duplicate_cread() {

		Utility.assertElementPresent(driver, first_name, 10);
		Utility.clickElement(driver, first_name, 10);
		Utility.sendKeys(driver, first_name, "aniket", 10);

		Utility.assertElementPresent(driver, last_name, 10);
		Utility.clickElement(driver, last_name, 10);
		Utility.sendKeys(driver, first_name, "patil", 10);

		Utility.assertElementPresent(driver, email, 10);
		Utility.clickElement(driver, email, 10);
		Utility.sendKeys(driver, email, "aniketpatil@gmail.com", 10);

		Utility.assertElementPresent(driver, password, 10);
		Utility.clickElement(driver, password, 10);
		Utility.sendKeys(driver, password, "aniket@123", 10);

		Utility.clickElement(driver, Privacy);
		Utility.clickElement(driver, ContinueBtn);

		Utility.assertElementPresent(driver, alert, 10);
		Utility.assertTextEqualsByElementText(driver, alert, " Warning: E-Mail Address is already registered!", 10);
	}
}
