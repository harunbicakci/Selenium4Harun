package com.neotech.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginWithAdvancedXPath extends CommonMethods{

	public static void main(String[] args) {
		
		// using parent child relationship in xpath
		
		setUp();
		
		WebElement username = driver.findElement(By.xpath("//form[@class='form-body']/div[1]/input"));
		sendText(username, ConfigsReader.getProperty("username"));
		
		WebElement password = driver.findElement(By.xpath("//div[@class='input-field'][1]/following-sibling::div[1]/input"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='txtPassword']/../following-sibling::div/button"));
		click(loginBtn);
		wait(2);
		
		tearDown();

	}

}
