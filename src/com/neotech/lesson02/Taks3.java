package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Taks3 {

//	Facebook sign up:
//	Open chrome browser
//	Go to “https://www.facebook.com/”
//	Click on Sign Up link
//	Enter first name
//	Enter last name
//	Enter email address
//	Re-enter email address
//	Click on Sign Up button

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);

		driver.findElement(By.name("firstname")).sendKeys("Charles");
		Thread.sleep(1000);
		driver.findElement(By.name("lastname")).sendKeys("Bukowski");
		Thread.sleep(1000);
		driver.findElement(By.name("reg_email__")).sendKeys("charles@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("charles@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(3000);

		driver.quit();

	}
}
