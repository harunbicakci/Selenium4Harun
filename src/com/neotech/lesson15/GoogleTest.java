package com.neotech.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

public class GoogleTest extends CommonMethods{

	public static void main(String[] args) {
		// https://www.google.com/
		
		setUp();

		// we use our own method to send text (which uses sendKeys())
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("bitcoin");
		wait(2);
		searchBox.sendKeys(Keys.ENTER);
		wait(2);
		
		
		wait(1);
		tearDown();
	}

}
