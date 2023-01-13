package com.neotech.lesson07;

import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class WindowHandlePractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		System.out.println("Title --> " + driver.getTitle());
		String mainPageId = driver.getWindowHandle();
		System.out.println("The main page id is: " + mainPageId);

		// click on the tab button
		Thread.sleep(2000);
		driver.findElement(By.id("tabButton")).click(); // 2nd page
		Thread.sleep(1000);

		// click on the window button
		Thread.sleep(2000);
		driver.findElement(By.id("windowButton")).click(); // 3rd page
		Thread.sleep(1000);

		// click on the message window button
		Thread.sleep(2000);
		driver.findElement(By.id("messageWindowButton")).click(); // 4th page
		Thread.sleep(1000);

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Number of handles: " + allWindowHandles.size());

		for (String handle : allWindowHandles) {

			if (!handle.equals(mainPageId)) {
				// switch to that page
				driver.switchTo().window(handle);

				Thread.sleep(2000);

				// close this page
				driver.close();
			}

		}

		Thread.sleep(1000);

		tearDown();

	}

}
