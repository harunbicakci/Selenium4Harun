package com.neotech.lesson02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("driver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();

		// 1st way
		// driver.get("https://www.facebook.com/");
		// will NOT store the history
		// wait for the page element to be loaded
		
		
		// 2nd way
		driver.navigate().to("https://www.facebook.com/");
		// saves the history
		// does NOT wait the page to be fully loaded 
		
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		// driver.manage().window().fullscreen(); --> makes full screen
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().forward();
		Thread.sleep(2000);
		
		driver.quit(); // after quiting you can not do anything
	}

}
