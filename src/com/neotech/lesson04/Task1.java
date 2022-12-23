package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();
		
		WebElement webOrders = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[1]/h1"));
		
		if(webOrders.isDisplayed()) {
			System.out.println("Web Orders displayed!");
		} else {
			System.out.println("Web Orders NOT displayed!");
		}
		
		WebElement loginInfo = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[1]"));
		
		if(loginInfo.isDisplayed()) {
			System.out.println("Username displayed!");
		} else {
			System.out.println("Username NOT displayed!");
		}
		
		driver.quit();
	}

}
