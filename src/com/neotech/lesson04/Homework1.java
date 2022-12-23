package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

	public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	
	public static void main(String[] args) throws InterruptedException {
		
//		Open chrome browser
//		Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
//		Enter valid username
//		Clear username and enter again valid username
//		Leave password field empty
//		Click on login button
//		Verify error message with text "Invalid Login or Password." is displayed.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(3000);
		
		WebElement logo = driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		if(logo.isDisplayed()) {
			System.out.println("The logo is displayed! logo.getText() --> " + logo.getText());
		}else {
			System.out.println("The logo is NOT displayed! logo.getText() --> " + logo.getText());
		}
		
		
		String name = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[1]")).getText();
		
		if(name.contains("Tester")) {
			System.out.println("Name displayed! --> " + name);
		}else {
			System.out.println("Name NOT displayed! --> " + name);
		}
		
		driver.quit();

	}

}
