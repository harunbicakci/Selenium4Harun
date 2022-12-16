package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chrome");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		// typing the email into the username texbox
		driver.findElement(By.id("email")).sendKeys("h_bicakci@msn.com");
		Thread.sleep(2000);
		
		// typing the password
		driver.findElement(By.name("pass")).sendKeys("123Asd");
		Thread.sleep(2000);
		
		// click in link --> Forgot Password?
		driver.findElement(By.linkText("Forgot password?")).click();
		Thread.sleep(2000);
		
		
		
		
		driver.quit();
		
	}
	
}
