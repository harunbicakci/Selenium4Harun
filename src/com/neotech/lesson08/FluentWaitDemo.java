package com.neotech.lesson08;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class FluentWaitDemo extends BaseClass {

	public static void main(String[] args) {
		// http://uitestpractice.com/Students/Contact

		setUp();

		// We can combine implicitlyWait and FluentWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.linkText("This is a Ajax link")).click();

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(25));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ContactUs")));
		
		WebElement div = driver.findElement(By.className("ContactUs"));

		boolean isDisplayed = div.isDisplayed();
		System.out.println("Div isDisplayed -> " + isDisplayed);
		
		tearDown();
	}

}
