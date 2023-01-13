package com.neotech.lesson07;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class Homework2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Alert text verification 
		 * Open chrome browser 
		 * Go to https://demoqa.com/ 
		 * Click on "Alerts, Frame & Windows" link 
		 * Click on "Alerts" links on the left side
		 * Click on button to see Alert Verify alert box with text
		 * "You clicked a button" is present 
		 * Click on 3rd button in the page 
		 * Verify alert box with text "Do you confirm action?" is present and 
		 * click "confirm"
		 * Click on 4rth button in the page and enter your name and click ok. Quit
		 * browser
		 */
		setUp();
		
		
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Alerts']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		
		
		//Now the pop-up alert is shown
		Alert alert = driver.switchTo().alert();
		System.out.println("The text of the alert is: " + alert.getText());

		alert.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.id("confirmButton")).click();
		
		
		Alert confirmAlert = driver.switchTo().alert();
		String resultTxt = confirmAlert.getText();
		System.out.println("resultTxt is: " + resultTxt);
		
		confirmAlert.accept();
		Thread.sleep(2000);
		
		
		//click on the prompt alert
		driver.findElement(By.id("promtButton")).click();
		
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Murad");
		Thread.sleep(2000);
		promptAlert.accept();
		Thread.sleep(2000);
		
		
		
		tearDown();

	}

}
