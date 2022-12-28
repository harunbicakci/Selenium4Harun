package com.neotech.lesson06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class AlertDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// http://uitestpractice.com/Students/Switchto

		setUp();
		
		driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("The simple alert says: " + alertText);
		Thread.sleep(2000);
		simpleAlert.accept();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("confirm")).click();
		
		//we are trying to swith the focus of the driver to the alert
		Alert confirm = driver.switchTo().alert();
		String confirmationText = confirm.getText();
		System.out.println(confirmationText);
		//if we want to accept this
		//	confirm.accept();
		//if I don't want to accept this
		confirm.dismiss();
		Thread.sleep(2000);
		
		//handling prompt alert
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		
		Alert prompt = driver.switchTo().alert();
		System.out.println(prompt.getText());
		prompt.sendKeys("Sabah");
		Thread.sleep(3000);
		prompt.accept();
			
		Thread.sleep(2000);

		tearDown();
	}

}
