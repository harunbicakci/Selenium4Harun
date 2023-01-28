package com.neotech.test;

import com.neotech.pages.DashboardPage;
import com.neotech.pages.LoginPage;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTestUsingPOM extends CommonMethods{

	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/
		
		setUp();
		
		// At this point we are locating the elements
		LoginPage login = new LoginPage();
		
		// sending the username
		sendText(login.username, ConfigsReader.getProperty("username"));
		
		// sending the password
		sendText(login.password, ConfigsReader.getProperty("password"));
		
		// click on Login button
		login.loginBtn.click();
		
		// same thing using the click() in CommonMethods
		// click(login.loginBtn);
		
		DashboardPage dp = new DashboardPage();
		
		if (dp.logo.isDisplayed()) {
			System.out.println("System login test passed!");
		}else {
			System.out.println("Login test failed!");
		}
		
		// lets validate that "Jacqueline White" is displayed
		String expectedName = "Jacqueline White";
		String actualName = dp.name.getText();
		
		if (actualName.equals(expectedName)) {
			System.out.println(actualName + " is displayed");
		}else {
			System.out.println(actualName + " is NOT displayed");
		}
		
		wait(3);
		tearDown();
	}
}
