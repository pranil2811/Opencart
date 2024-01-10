package com.page_class;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		first_name.clear();
		Assert.assertEquals(true, first_name.isEnabled());
		first_name.click();
		first_name.sendKeys("shubham");
		last_name.clear();
		Assert.assertEquals(true, last_name.isEnabled());
		last_name.click();
		last_name.sendKeys("shedge");
		email.clear();
		Assert.assertEquals(true, email.isEnabled());
		email.click();
		email.sendKeys("shubhamshedge@gmail.com");
		password.clear();
		Assert.assertEquals(true, email.isEnabled());
		password.click();
		Assert.assertEquals(true, email.isEnabled());
		password.sendKeys("shubham@123");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(Privacy));

//		Actions ac = new Actions(driver);
//		ac.moveToElement(Privacy).click().build().perform();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Privacy);
		
//		Privacy.click();
		Assert.assertEquals(true, ContinueBtn.isDisplayed());
		
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", ContinueBtn);
		
//		ContinueBtn.click();
		Assert.assertEquals("Your Account Has Been Created!", Heading.getText());
		Assert.assertEquals(true, SuccussPage_ContinueBtn.isDisplayed());
		SuccussPage_ContinueBtn.click();
		
	}
	
	public void empty_cred() {
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", ContinueBtn);
		
//		ContinueBtn.click();
		String a = errorFirstname.getText();
		
		Assert.assertEquals("First Name must be between 1 and 32 characters!", a);
//		Assert.assertEquals("Last Name must be between 1 and 32 characters!", errorLastname.getText());
//		Assert.assertEquals("E-Mail Address does not appear to be valid!", errorEmail.getText());
//		Assert.assertEquals("Password must be between 4 and 20 characters!", errorPassword.getText());
	}
	
	public void duplicate_cread() {
		first_name.clear();
		Assert.assertEquals(true, first_name.isEnabled());
		first_name.click();
		first_name.sendKeys("shubham");
		last_name.clear();
		Assert.assertEquals(true, last_name.isEnabled());
		last_name.click();
		last_name.sendKeys("shedge");
		email.clear();
		Assert.assertEquals(true, email.isEnabled());
		email.click();
		email.sendKeys("pranilpalse7@gmail.com");
		password.clear();
		Assert.assertEquals(true, email.isEnabled());
		password.click();
		Assert.assertEquals(true, email.isEnabled());
		password.sendKeys("shubham@123");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(Privacy));

		Actions ac = new Actions(driver);
		ac.moveToElement(Privacy).click().build().perform();
		
//		Privacy.click();
		Assert.assertEquals(true, ContinueBtn.isDisplayed());
		ContinueBtn.click();
		
		Assert.assertEquals(" Warning: E-Mail Address is already registered!'", alert.getText());
	}
	
	
	
	

}
