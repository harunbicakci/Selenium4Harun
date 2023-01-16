package com.neotech.test;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;

public class WindowHandleDemoTest extends CommonMethods{

	public static void main(String[] args) {
		
//	Homework 2:
//	WindowHandle_Demo at com.neotech.lesson07 using the CommonMethods.java
//	https://accounts.google.com/signup
		
		setUp();
		
		System.out.println("Title --> " + driver.getTitle());
		System.out.println("Handle --> " + driver.getWindowHandle());
		
		click(driver.findElement(By.linkText("Help")));
		wait(2);
		
		switchToChildWindow();

		System.out.println("Title --> " + driver.getTitle());
		System.out.println("Handle --> " + driver.getWindowHandle());

		wait(2);
		driver.close();
		
		wait(2);
		
		tearDown();
	}

}
