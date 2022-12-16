package com.neotech.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
	
		// /Users/harunbicakci/eclipse-workspace/Selenium4Harun/drivers/chromedriver --> Full Path
		// drivers.chromedriver --> Relative Path
		// for mac drivers/chromedriver
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // which driver and where it is 
		
		// creating a new object of ChromeDriver
		// upcasting it to WebDriver
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.neotechacademy.com/");
		
		String url = driver.getCurrentUrl();
		System.out.println("url: " + url); 
		
		String title = driver.getTitle();
		System.out.println("title: " + title);
		
		Thread.sleep(5000); // 5000 milliseconds --> 5 seconds
		
		driver.close();
		
		
	}
}
