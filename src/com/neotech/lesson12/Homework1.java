package com.neotech.lesson12;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;

public class Homework1 extends CommonMethods {

	public static void main(String[] args) {
		//http://uitestpractice.com/Students/Switchto
		setUp();

		//switchToFrame by index
		switchToFrame(0);
		sendText(driver.findElement(By.id("name")),"Brikenda");
		wait(2);
		
		driver.switchTo().defaultContent();
				
		//switchToFrame by name
		switchToFrame("iframe_a");
		sendText(driver.findElement(By.id("name")), "Sedat");
		wait(2);
		
		driver.switchTo().defaultContent();

		//switchToFrame by WebElement
		switchToFrame(driver.findElement(By.xpath("//iframe[@name='iframe_a']")));
		sendText(driver.findElement(By.id("name")),"Emine");
		wait(2);
		
		driver.switchTo().defaultContent();
		
		
		
		tearDown();
	}
	
}
