package com.neotech.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LoginTest extends CommonMethods{

	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/
		setUp();
		
		// sending the username
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));
		
		// sending the password
		WebElement password = driver.findElement(By.name("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		// click on Login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
		
		// wait for 4 seconds
		wait(4);
		
		// validate that Login was successful by locating the logo
		WebElement logo = driver.findElement(By.id("ohrm-small-logo"));
		if (logo.isDisplayed()) {
			System.out.println("System login test passed!");
		}else {
			System.out.println("Login test failed!");
		}
		
		tearDown();
		
	}

}
