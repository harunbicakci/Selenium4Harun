package com.neotech.lesson05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Homework1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
	
//	HW1: Orange HRM Application Login:
//	Open Chrome browser
//	Go to https://hrm.neotechacademy.com/
//	Enter valid username and password
//	Click on login button
//	Then verify that "span with id account-name" has the text "Jacqueline White".
//	Quit the browser

		setUp();
		
		WebElement un = driver.findElement(By.id("txtUsername"));
		un.clear();
		un.sendKeys(ConfigsReader.getProperty("username"));
			
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.clear();
		pass.sendKeys(ConfigsReader.getProperty("password"));
		
		driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div[2]/div/form/div[3]/button")).click();
		Thread.sleep(2000);
		
		String expectedText = "Jacqueline White";
		String text = driver.findElement(By.id("account-name")).getText();
		
		if(text.equals(expectedText)) {
			System.out.println("Account name verified --> " + text);
		}else {
			System.out.println("Account name test failed! --> " + text);
		}
		Thread.sleep(2000);
		
		tearDown();
	}

}
