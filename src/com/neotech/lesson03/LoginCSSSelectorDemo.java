package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCSSSelectorDemo {

	public final static String url1 = "http://sis.neotechacademy.com:9000/Test/";
	
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url1);
		
		// using xpath	--->  //input[id='tUsername']
		// using css ---> input#tUsername (#tUsername) (tag#id)
		
		driver.findElement(By.cssSelector("input#tUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#tPassword")).sendKeys("Neotech$123");
		
		// click on login
		// using css --> input.buttonBig
		driver.findElement(By.cssSelector("input.buttonBig")).click();
		
		// a[href$='Personal.aspx']
		
		driver.findElement(By.cssSelector("a[href$='Personal.aspx']")).click();
		
		
		
		
	}

}
