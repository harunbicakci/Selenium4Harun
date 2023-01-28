package com.neotech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginPage extends CommonMethods{

	public WebElement username = driver.findElement(By.id("txtUsername"));
	
	public WebElement password = driver.findElement(By.id("txtPassword"));
	
	public WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	
	
//	public void loginWithAdmin(String username, String password) {
//		sendText(username, ConfigsReader.getProperty("username"));
//		sendText(password, ConfigsReader.getProperty("password"));
//	}
	
	
}
