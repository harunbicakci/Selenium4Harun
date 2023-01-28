package com.neotech.test;

import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTestUsingFactory extends CommonMethods{

	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/
		
		setUp();
		
		// at this point we are not locating the elements
		// we are just telling how the elements will be located
		LoginPageUsingFactory login = new LoginPageUsingFactory();
		
		// sending the username
		sendText(login.username, ConfigsReader.getProperty("username"));
		
		// sending the password
		sendText(login.password, ConfigsReader.getProperty("password"));
		
		// click on the login button
		login.loginBtn.click();
		
		DashboardPageUsingFactory dpuf = new DashboardPageUsingFactory();
		
		if(dpuf.logo.isDisplayed()) {
			System.out.println("Displayed!");
		}else {
			System.out.println("NOT displayed!");
		}
		
		// lets validate that "Jacqueline White" is displayed
		String expectedName = "Jacqueline White";
		String actualName = dpuf.name.getText();
				
		if (actualName.equals(expectedName)) {
			System.out.println(actualName + " is displayed");
		}else {
			System.out.println(actualName + " is NOT displayed");
		}
		
		
		wait(2);
		
		tearDown();
	}
}
