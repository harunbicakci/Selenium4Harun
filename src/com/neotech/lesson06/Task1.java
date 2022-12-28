package com.neotech.lesson06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Task1 extends BaseClass{

//	 * TC 1: Facebook dropdown verification 
//	 * 1. Open chrome browser 
//	 * 2. Go to https://www.facebook.com/r.php 
//	 * 3. Verify: month dd has 12 month options day dd has 31 day options year dd has 118 year options 
//	 * 4. Select your date of birth 
//	 * 5. Quit browser
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		WebElement month = driver.findElement(By.id("month"));
		Select monthMenu = new Select(month);
		List<WebElement> monthOption = monthMenu.getOptions();
		
		WebElement day = driver.findElement(By.id("day"));
		Select dayMenu = new Select(day);
		List<WebElement> dayOption = dayMenu.getOptions();
		
		WebElement year = driver.findElement(By.id("year"));
		Select yearMenu = new Select(year);
		List<WebElement> yearOption = yearMenu.getOptions();
		
		if(monthOption.size() == 12) {
			System.out.println("Month size is verified --> " + monthOption.size());
		}else {
			System.out.println("Month size is NOT verified --> " + monthOption.size());
		}
		
		if(dayOption.size() == 31) {
			System.out.println("Month size is verified --> " + dayOption.size());
		}else {
			System.out.println("Month size is NOT verified --> " + dayOption.size());
		}
		
		if(yearOption.size() == 118) {
			System.out.println("Month size is verified --> " + yearOption.size());
		}else {
			System.out.println("Month size is NOT verified --> " + yearOption.size());
		}
		
		monthMenu.selectByValue("10");
		Thread.sleep(1000);
		dayMenu.selectByValue("1");
		Thread.sleep(1000);
		yearMenu.selectByValue("1983");
		Thread.sleep(1000);
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(3000);
		
		tearDown();
		
	}
	
}
