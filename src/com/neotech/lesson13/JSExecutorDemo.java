package com.neotech.lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class JSExecutorDemo extends CommonMethods{

	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/
		
		setUp();
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		wait(2);
		
		//create an object of JSExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//arguments[0] --> means first WebElement after the code
		//arguments[1] --> means the second WebElement after the code
		
		js.executeScript("arguments[0].style.backgroundColor='blue';"
				+ "arguments[1].style.backgroundColor='red'", 
				username, password);

		wait(5);
		
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@type='submit']")));
		
		//go to employee list
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		click(driver.findElement(By.linkText("Employee List")));
		
		wait(5);
		
		
		//scrolling with JS -- down by 1000px
		js.executeScript("window.scrollBy(0,2000)");
		wait(3);
		
		
		//scrolling up -- by 300 pixels
		js.executeScript("window.scrollBy(0,-300)");
		wait(4);
		
		
		
		//scroll into view -- scroll until we see a web element
		WebElement home = driver.findElement(By.id("home-menu-trigger"));
		js.executeScript("arguments[0].scrollIntoView(true)", home);
		
		wait(3);
		System.out.println("---Done---");
		
		tearDown();

	}

}
