package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample extends Base{
	
	@Test(priority = 1)
	public void demo() throws InterruptedException {
		
		driver.get(url);
		
		WebElement mac = driver.findElement(By.xpath("//a[text()='MacBook']"));
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.elementToBeClickable(mac));
		
//		mac.click();
		System.out.println("before click");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", mac);
		System.out.println("after click");
//		Actions actions = new Actions(driver);
//		actions.moveToElement(mac).click().build().perform();
		
		Thread.sleep(5000);
		
		driver.close();

	}


}
