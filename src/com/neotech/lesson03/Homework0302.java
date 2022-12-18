package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework0302 {

	public final static String url1 = "http://demo.guru99.com/test/newtours/";
	
	public static void main(String[] args) throws InterruptedException {
		
//		Using Css ONLY
//		TC 2: Mercury Tours Registration:
//		1. Open chrome browser
//		2. Go to “http://demo.guru99.com/test/newtours/”
//		3. Click on Register Link
//		4. Fill out all required info
//		5. Click Submit
//		6. User successfully registered

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[href='register.php']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[name='firstName")).sendKeys("Haruna");
		driver.findElement(By.cssSelector("input[name='lastName")).sendKeys("Babangida");
		driver.findElement(By.cssSelector("input[name='phone")).sendKeys("409-123-98-22");
		driver.findElement(By.cssSelector("input[name='userName")).sendKeys("harunababangida@yahoo.com");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[name='address1")).sendKeys("666 Number of the Beast Street");
		driver.findElement(By.cssSelector("input[name='city")).sendKeys("London");
		driver.findElement(By.cssSelector("input[name='state")).sendKeys("England");
		driver.findElement(By.cssSelector("input[name='postalCode")).sendKeys("66612");
		driver.findElement(By.cssSelector("*[name='country")).sendKeys("UNITED KINGDOM");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[name='email")).sendKeys("harunababangida@yahoo.com");
		driver.findElement(By.cssSelector("input[name='password")).sendKeys("123asd");
		driver.findElement(By.cssSelector("input[name='confirmPassword")).sendKeys("123asd");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("*[name='submit']")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}

}
