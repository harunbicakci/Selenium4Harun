package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 {

	public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	
	public static void main(String[] args) throws InterruptedException {
	
//	Open chrome browser, go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
//	Enter valid username, clear username and enter again valid username. Leave password field empty
//	Click on login button, verify error message with text “Invalid Login or Password.” is displayed.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ctl00_MainContent_username")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();
		Thread.sleep(1000);
		WebElement error = driver.findElement(By.cssSelector("#ctl00_MainContent_status"));
		
		System.out.println(error.getText());
		
		if(error.getText().equals("Invalid Login or Password.")) {
			System.out.println("Login error occured --> " + error.getText());
		}
		driver.quit();
	}

}
