package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class FrameDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		// http://uitestpractice.com/Students/Switchto
		
		setUp();
		
		// there are 3 ways how we switch to frame
		
		// 1st way: switchTo frame by index
		
		driver.switchTo().frame(0); // switch attention to frame index 0
		
		WebElement nameBox = driver.findElement(By.id("name"));
		nameBox.sendKeys("Brikenda");
		Thread.sleep(1000);
		
		// can I click on the Home button?
		// we have to return to the main page
		
		// this will switch the focus of the driver to the main page
		driver.switchTo().defaultContent();
		
		// 2nd way: switchTo frame by name
		driver.switchTo().frame("iframe_a");
		nameBox.clear();
		nameBox.sendKeys("Sedat");
		Thread.sleep(2000);
	
		driver.switchTo().defaultContent();
		
		
		// 3rd way: switch to using a WebElement
		WebElement frame = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		driver.switchTo().frame(frame);
		// or in one line:
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='iframe_a']")));
		nameBox.clear();
		nameBox.sendKeys("Emine");
		Thread.sleep(2000);
		
		// switch back to outside the frame
		driver.switchTo().defaultContent();
		
		tearDown();
		
		
		
	}

}
