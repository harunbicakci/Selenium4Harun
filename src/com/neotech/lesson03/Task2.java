package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public final static String url1 = "https://www.facebook.com/"; 
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url1);
		
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("edgardavids@gmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("edgar123");
		driver.findElement(By.cssSelector("button[type='submit']")).click(); // --> "button[name='login']"
		
		Thread.sleep(7000);
		
		driver.quit();		

	}

}
