package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class ExplicitWaitDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		driver.findElement(By.linkText("This is a Ajax link")).click();
		
		// we are creating an object of WebDriverWait
		// we are defining the maximum time to wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
		// we are difining the condition for which element to wait
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("ContactUs"))));		
		
		WebElement div = driver.findElement(By.className("ContactUs"));
		boolean isDisplayed = div.isDisplayed();
		System.out.println("Div isDisplayed --> " + isDisplayed);
		
		Thread.sleep(1000);
		tearDown();
	}
}
