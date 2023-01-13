package com.neotech.lesson09;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.neotech.utils.BaseClass;

public class Homework2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Homework 1: Use WebDriverWait Verify element is enabled 
		 * Open chrome browser
		 * Go to "https://the-internet.herokuapp.com/" 
		 * Click on the "Dynamic Controls" link 
		 * Click on enable button 
		 * Enter "Hello" and verify text is entered successfully 
		 * Close the browser
		 */
		
		setUp();

		//implicit wait:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		
		//click on enable button
		driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
		
		
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(20));
		fluentWait.pollingEvery(Duration.ofSeconds(2));
		//DIFFERENCE
		fluentWait.ignoring(NoSuchElementException.class);
	
		WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']/input"));

		fluentWait.until(ExpectedConditions.elementToBeClickable(textBox));
		
		textBox.sendKeys("Mehmet");
		
		Thread.sleep(2000);
		
		System.out.println(textBox.getAttribute("value"));

		
		tearDown();

	}
}
