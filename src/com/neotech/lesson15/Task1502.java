package com.neotech.lesson15;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Task1502 extends CommonMethods{

//	Homework 2: OrangeHRM Login
//  Navigate to https://hrm.neotechacademy.com/
//  Login to the application by writing xpath based on "following and preceding siblings"

	public static void main(String[] args) {
		
		setUp();
		
		Task1502PageUsingFactory login = new Task1502PageUsingFactory();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		wait(2);
		System.out.println("Task passed!");
		tearDown();
	}
}
