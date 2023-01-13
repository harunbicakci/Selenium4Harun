package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class Task1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

//		  ------Use WebDriverWait------
//        Verify element is enabled
//        Open chrome browser
//        Go to "https://the-internet.herokuapp.com/"
//        Click on the "Dynamic Controls" link
//        Click on enable button
//        Enter "Hello" and verify text is entered successfully
//        Close the browser
		
		setUp();
		
		driver.findElement(By.xpath("//a[@href='/dynamic_controls']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		
		
		
		
		
		WebElement entry = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		entry.sendKeys("Hello");
				
		if(entry.getAttribute("value").equals("Hello")) {
			System.out.println("Entry is verified successfully!");
		}else {
			System.out.println("XXX - Entry not verified! - XXX");
		}
		
		Thread.sleep(2000);
		
		tearDown();
	}

}
