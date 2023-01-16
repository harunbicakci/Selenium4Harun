package com.neotech.lesson12;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;

public class Homework2 extends CommonMethods {

	public static void main(String[] args) {
		//https://accounts.google.com/signup
		
		setUp();
		System.out.println("Title of the parent page is: " + driver.getTitle());
		
		click(driver.findElement(By.linkText("Help")));
		
		
		switchToChildWindow();

		System.out.println("Title of the child page is: "+ driver.getTitle());
		
//		driver.close();//this closes the child window
	
		
		
		tearDown();
	}
}
