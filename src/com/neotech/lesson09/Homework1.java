package com.neotech.lesson09;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class Homework1 extends BaseClass {

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
		
	
		//situation: element is there, but is not interactable (is inactive)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']/input"));

		//if I have the element i can use visibilityOf
		//if I want to locate the element I can use the visibilityOfElementLocated(By...)
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		
		
		//element is already visible 
		//wait.until(ExpectedConditions.visibilityOf(textBox));
		
		
		textBox.sendKeys("Mehmet");
		
		Thread.sleep(4000);
		
		tearDown();
	}

}
