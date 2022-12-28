package com.neotech.lesson06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class Homework02 extends BaseClass{

//    Alert text verification
//    Open chrome browser
//    Go to https://demoqa.com/
//    Click on "Alerts, Frame & Windows" link
//    Click on "Alerts" links on the left side
//    Click on button to see Alert
//    Verify alert box with text "You clicked a button" is present
//    Click on 3rd button in the page
//    Verify alert box with text "Do you confirm action?" is present and click "confirm"
//    Click on 4 th button in the page and enter your name and click ok.
//    Quit browser
	
	public static void main(String[] args) throws Exception {
		
		setUp();
	
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Alerts']")).click();
		Thread.sleep(2000);
// 1st Button
		driver.findElement(By.id("alertButton")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("The alert is --> " + alertText);
		
		if(alertText.equals("You clicked a button")) {
			System.out.println("Alert test passed!");
		}else {
			System.out.println("Alert test NOT passed!");
		}
		Thread.sleep(1000);
		simpleAlert.accept();
		Thread.sleep(2000);
// 2nd Button		
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmBtnAlert = driver.switchTo().alert();
		String AlertText2 = confirmBtnAlert.getText();
		if(AlertText2.equals("Do you confirm action?")) {
			System.out.println("Second alert test passed --> " + AlertText2);
		}else {
			System.out.println("Second alert test NOT passed --> " + AlertText2);
		}
		Thread.sleep(1000);
		simpleAlert.accept();
		Thread.sleep(2000);
// 3rd Button
		driver.findElement(By.id("promtButton")).click();
		Alert promtBtnAlert = driver.switchTo().alert();
		System.out.println(promtBtnAlert.getText());
		promtBtnAlert.sendKeys("Harun Bicakci");
		Thread.sleep(1000);
		simpleAlert.accept();
		Thread.sleep(2000);
		
		tearDown();
	}
}
