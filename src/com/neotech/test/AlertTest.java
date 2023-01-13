package com.neotech.test;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;

public class AlertTest extends CommonMethods{

	public static void main(String[] args) {

		// http://uitestpractice.com/Students/Switchto
		
		setUp();
		
		driver.findElement(By.id("alert")).click();
		wait(2);
		
		System.out.println(getAlertText());
		acceptAlert();
		wait(2);
		
		driver.findElement(By.id("confirm")).click();
		System.out.println(getAlertText());
		dismissAlert();
		wait(2);
		
		driver.findElement(By.id("prompt")).click();
		System.out.println(getAlertText());
		sendAlertText("Flori lost in Domino");
		acceptAlert();
		
		wait(5);
		
		tearDown();
	}

}
