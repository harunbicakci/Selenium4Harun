package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {

	// URL 
	public final static String url1 = "https://www.facebook.com/"; 
	
	public static void main(String[] args) throws InterruptedException {
		
//		Facebook sign up:
//		Open chrome browser
//		Go to “https://www.facebook.com/”
//		Click on Sign Up link
//		Enter first name
//		Enter last name
//		Enter email address
//		Re-enter email address
//		Click on Sign Up button

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url1);
		
		driver.findElement(By.linkText("Create new account")).click();
		
		Thread.sleep(2000);
		
		 driver.findElement(By.name("firstname")).sendKeys("John");
		 driver.findElement(By.name("lastname")).sendKeys("Smith");
		 driver.findElement(By.name("reg_email__")).sendKeys("johnsmith@gmail.com");
		 driver.findElement(By.name("reg_email_confirmation__")).sendKeys("johnsmith@gmail.com");
		 driver.findElement(By.name("reg_passwd__")).sendKeys("123asd?");
		
		 Thread.sleep(3000);
		 
		 driver.quit();
		
	}
}
