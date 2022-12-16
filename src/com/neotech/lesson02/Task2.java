package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

//	Facebook login:
//	Open chrome browser
//	Go to “https://www.facebook.com/”
//	Enter invalid username and password and click login
//	User should see invalid user name Page.
//	Close the browser

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("kobe@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Kobe123!");
		
		driver.findElement(By.name("login")).click();
		Thread.sleep(30000);
		
		driver.quit();
		
		
		
	}
}
