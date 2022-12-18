package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework0301 {

	public final static String url1 = "https://demo.guru99.com/test/newtours/";
		
	public static void main(String[] args) throws InterruptedException {
		
//		Using xPath ONLY
//		TC 2: Mercury Tours Registration:
//		1. Open chrome browser
//		2. Go to “http://demo.guru99.com/test/newtours/”
//		3. Click on Register Link
//		4. Fill out all required info
//		5. Click Submit
//		6. User successfully registered

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url1);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href='register.php']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("George");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Orwell");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("407-123-45-67");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("georgeorwell@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("1984 East London Street");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Orlando");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("FL");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("32819");
		driver.findElement(By.xpath("//*[@name='country']")).sendKeys("UNITED STATES");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("georgeorwell@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123asd");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("123asd");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
