package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
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
		
		// full xpath
//		/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a

		driver.findElement(By.xpath("//*[@data-testid=\'open-registration-form-button']")).click();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//*[@name=\'firstname']")).sendKeys("Kobe");
		driver.findElement(By.xpath("//*[@name=\'lastname']")).sendKeys("Bryant");
		driver.findElement(By.xpath("//*[@name=\'reg_email__']")).sendKeys("kobe@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name=\'reg_email_confirmation__']")).sendKeys("kobe@gmail.com");
		driver.findElement(By.xpath("//*[@name=\'reg_passwd__']")).sendKeys("123asd");
		driver.findElement(By.xpath("//*[@name=\'websubmit']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\'month\']")).sendKeys("Feb");
		driver.findElement(By.xpath("//*[@id=\'day\']")).sendKeys("28");
		driver.findElement(By.xpath("//*[@id=\'year\']")).sendKeys("1984");
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/label")).click();
		
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(3000);
			
		driver.quit();
	}
}
