package com.neotech.lesson15;

import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Task1402 extends CommonMethods{

//	TC 2: Orange HRM wrong password validation
//	1. Go to https://hrm.neotechacademy.com/
//	2. Enter valid username and wrong password
//	3. Click on login button
//	4. Verify error message with text "Invalid Credentials" is displayed
	
	public static void main(String[] args) {
		
		setUp();
		
		LoginPageUsingFactory login = new LoginPageUsingFactory();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "wrongPassword");
		click(login.loginBtn);
		wait(2);
		
		String expectedText = "Invalid Credentials";
		
		if(login.invalidMsg.isDisplayed()) {
			if(login.invalidMsg.getText().equals(expectedText)) {
				System.out.println("Error message verified --> " + expectedText);
			}else {
				System.out.println("Error message shown but not veriried --> " + login.invalidMsg.getText());
			}
		}else {
			System.out.println("Password error NOT displayed!");
		}
		
		tearDown();
	}
}
