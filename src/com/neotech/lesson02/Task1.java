package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

//	Mercury Tours Registration:
//	Open chrome browser
//	Go to “https://demo.guru99.com/test/newtours/”
//	Click on Register Link
//	Fill out ALL required info
//	Click Submit
//	User successfully registered
//	(Create the script using different locators)

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");

		driver.manage().window().maximize();
		Thread.sleep(1000);

		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(1000);

		driver.findElement(By.name("firstName")).sendKeys("Lebron");
		driver.findElement(By.name("lastName")).sendKeys("James");
		driver.findElement(By.name("phone")).sendKeys("4041234567");
		driver.findElement(By.name("userName")).sendKeys("lebron@gmail.com");
		System.out.println("---------------------------");
		driver.findElement(By.name("address1")).sendKeys("123 Slamdunk Blv.");
		driver.findElement(By.name("city")).sendKeys("Los Angeles");
		driver.findElement(By.name("state")).sendKeys("CA");
		driver.findElement(By.name("postalCode")).sendKeys("45678");
		
		driver.findElement(By.name("country")).sendKeys("united states");
//		WebElement selection = driver.findElement(By.name("country"));
//		selection.click();
//		selection.sendKeys("united states");
		
		System.out.println("---------------------------");
		driver.findElement(By.name("email")).sendKeys("lebron@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Lebron123?");
		driver.findElement(By.name("confirmPassword")).sendKeys("Lebron123?");

		Thread.sleep(2000);

		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);

		driver.quit();

	}
}
