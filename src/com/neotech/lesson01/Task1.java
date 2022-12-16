package com.neotech.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

//	HW1: Amazon Page Title Verification: 
//	Open chrome browser
//	Go to “https://www.amazon.com/”
//	Verify Title “Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more” is displayed
//	End the Session (close the browser).

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		String title = driver.getTitle();
		
		if(title.equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
			System.out.println("Title confirmed!");
		}else {
			System.out.println("Title is wrong! Here it is --> " + title);
		}
		
		Thread.sleep(3000);
		
		driver.close();
		
	}
	
}
