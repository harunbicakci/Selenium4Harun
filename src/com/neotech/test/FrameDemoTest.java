package com.neotech.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

public class FrameDemoTest extends CommonMethods{

	public static void main(String[] args) {
		
//	Homework 1:
//	FrameDemo at com.neotech.lesson07 using the CommonMethods.java
//	//https://uitestpractice.com/Students/Switchto
		
		setUp();
		
		switchToFrame("iframe_a");
		WebElement txtBox = driver.findElement(By.id("name"));
		sendText(txtBox, "Martin");
		wait(2);
		
		driver.switchTo().defaultContent();
		
		switchToFrame(0);
		sendText(txtBox, "Luther");
		wait(2);
		
		driver.switchTo().defaultContent();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		switchToFrame(frame);
		sendText(txtBox, "King");
		wait(2);
		
		tearDown();
	}

}
