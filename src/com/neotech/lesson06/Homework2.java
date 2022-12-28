package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Homework2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * TC 2: Orange HRM Application Negative Login: 
		 * Open Chrome browser 
		 * Go to https://hrm.neotechacademy.com/ 
		 * Enter valid username 
		 * Leave password field empty 
		 * Verify error message with text "Password cannot be empty" is displayed.
		 */
		
		setUp();
		
		String user = ConfigsReader.getProperty("username");
		String pass = "";
		
		
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		Thread.sleep(3000);
		
		
		WebElement errorMsg = driver.findElement(By.id("txtPassword-error"));

		if(errorMsg.isDisplayed())
		{
			System.out.println("Test Passed!");
		}
		else
		{
			System.out.println("Test Failed!");
		}
		
		Thread.sleep(3000);

		tearDown();
	}
}
