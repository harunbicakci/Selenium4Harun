package com.neotech.lesson15;

import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework1 extends CommonMethods {

	public static void main(String[] args) {

		/*
		 * TC 1: Orange HRM blank password validation 
		 * 1. Go to https://hrm.neotechacademy.com/ 
		 * 2. Enter valid username and leave password field empty 
		 * 3. Click on login button 
		 * 4. Verify error message with text "Password cannot be empty" is displayed
		 */	

		setUp();

		LoginPageUsingFactory loginPage = new LoginPageUsingFactory();
		
		
		sendText(loginPage.username, ConfigsReader.getProperty("username"));
		
		wait(2);
		
		click(loginPage.loginBtn);
		wait(2);

		String expectedText = "Password cannot be empty";
		String actualText = loginPage.passwordError.getText();

		if(expectedText.equals(actualText))
		{
			System.out.println("Test passed!");
		}
		else
		{
			System.out.println("Test failed!");
		}

		tearDown();
		
	}
}