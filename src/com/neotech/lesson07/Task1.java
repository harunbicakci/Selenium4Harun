package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Task1 extends BaseClass{

//	1) Launch the browser and open the site "http://demo.guru99.com/popup.php"
//	2) Click on link "Click Here". When the user clicks on the "Click Here" link, new child window opens.
//	3) On the Child Window, Enter your email ID and submit.
//	4) Then Access Credentials will be Displayed on submitted page. You will see the child window is open in new tab.
//	5) Close the Child window on which credentials are displayed.Switch to the parent window.
//	6) Quit all browsers
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
	
		
		driver.findElement(By.xpath("//a[@href='../articles_popup.php']")).click();
		Thread.sleep(2000);
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		String window1 = it.next();
		String window2 = it.next();
	
		driver.switchTo().window(window2);
		
		driver.findElement(By.name("emailid")).sendKeys("lebronjames@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);
		
		WebElement userID = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
		System.out.println("User ID --> " + userID.getText());
		WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));
		System.out.println("Password --> " + password.getText());
		
		driver.close();
		
		driver.switchTo().window(window1);
		
		Thread.sleep(2000);

		tearDown();
	}

}
