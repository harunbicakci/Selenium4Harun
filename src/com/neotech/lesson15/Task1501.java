package com.neotech.lesson15;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Task1501 extends CommonMethods{

//	Homework 1: OrangeHRM Login
//  Navigate to https://hrm.neotechacademy.com/
//  Login to the application by writing xpath based on "parent and child relation"

	public static void main(String[] args) {
		
		setUp();
		
		Task1501PageUsingFactory login = new Task1501PageUsingFactory();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		wait(2);
		System.out.println("Task Done!");
		tearDown();
	}
}
