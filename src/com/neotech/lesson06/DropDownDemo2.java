package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class DropDownDemo2 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		WebElement oldMenu = driver.findElement(By.id("oldSelectMenu"));
		Select selDD = new Select(oldMenu);
		
		selDD.selectByIndex(1);
		Thread.sleep(3000);
		
		
		
		WebElement otherMenu = driver.findElement(By.id("withOptGroup"));
		otherMenu.click();
		Thread.sleep(3000);
		
		tearDown();
	}

}


