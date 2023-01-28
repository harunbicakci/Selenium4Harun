package com.neotech.lesson15;

import org.openqa.selenium.WebElement;

import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Task1401 extends CommonMethods{

//	TC 1: Orange HRM blank password validation
//	1. Go to https://hrm.neotechacademy.com/
//	2. Enter valid username and leave password field empty
//	3. Click on login button
//	4. Verify error message with text "Password cannot be empty" is displayed

	public static void main(String[] args) {
		
		setUp();
		
		LoginPageUsingFactory login = new LoginPageUsingFactory();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "");
		click(login.loginBtn);
		wait(2);
		
		String expectedText = "Password cannot be empty";
		
		if(login.passwordError.isDisplayed()) {
			if(login.passwordError.getText().equals(expectedText)) {
				System.out.println("Error message verified --> " + expectedText);
			}else {
				System.out.println("Error message shown but not veriried --> " + login.passwordError.getText());
			}
		}else {
			System.out.println("Password error NOT displayed!");
		}
		
		tearDown();
	}
}
