package com.neotech.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

public class FacebookSignUp extends CommonMethods{

	public static void main(String[] args) {
		
		
		
		setUp();
		
		WebElement month = driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.id("day"));
		WebElement year = driver.findElement(By.id("year"));
				
		selectDropDown(month, "Apr");
		selectDropDown(day, "3");
		selectDropDown(year, "1980");
		
		wait(2);
		
		tearDown();
		
	}

}
