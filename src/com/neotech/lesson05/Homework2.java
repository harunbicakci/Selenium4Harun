package com.neotech.lesson05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Homework2 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
//	TC 2: Orange HRM Application Negative Login: 
//	Open Chrome browser
//	Go to https://hrm.neotechacademy.com/
//	Enter valid username
//	Leave password field empty
//	Verify error message with text "Password cannot be empty" is displayed.

		setUp();
		
		WebElement us = driver.findElement(By.cssSelector("#txtUsername"));
		us.clear();
		us.sendKeys(ConfigsReader.getProperty("username"));
		
		WebElement pass = driver.findElement(By.cssSelector("#txtPassword"));
		pass.clear();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();;
		
		String expectedText = "Password cannot be empty";
		String actualText = driver.findElement(By.xpath("//span[@id='txtPassword-error']")).getText();
		
		if(actualText.equals(expectedText)) {
			System.out.println("Error message test passed and verified! --> " + actualText);
		}else {
			System.out.println("Error message test NOT passed! --> " + actualText);
		}
		Thread.sleep(2000);
		
		tearDown();
	}

}
