package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class WindowHandleDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		// https://accounts.google.com/signup
		
		setUp();
		Thread.sleep(1000);
		
		System.out.println("Title ----> " + driver.getTitle());
		
		// this will give us a unique id for this window/tab
		System.out.println("Handle ----> " + driver.getWindowHandle());
		
		driver.findElement(By.linkText("Help")).click();
		Thread.sleep(2000);
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Number of open windows/tabs is: " + allWindowHandles.size());
		
		Iterator<String> it = allWindowHandles.iterator();
		String window1 = it.next();
		String window2 = it.next();
		
		System.out.println("Window1: " + window1);
		System.out.println("Window2: " + window2);

		// switching to window 2
		driver.switchTo().window(window2);
		
		// get the title of  the window we switched to
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		driver.close();
		Thread.sleep(2000);
		
		
		tearDown();

	}

}
