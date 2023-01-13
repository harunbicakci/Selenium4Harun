package com.neotech.lesson08;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.neotech.utils.BaseClass;

public class Task2 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
//		----Use FluentWait----
//      Verify element is enabled
//      Open chrome browser
//      Go to "https://the-internet.herokuapp.com/"
//      Click on the "Dynamic Controls" link
//      Click on enable button
//      Enter "Hello" and verify text is entered successfully
//      Close the browser
		
		setUp();
		
		driver.findElement(By.xpath("//a[@href='/dynamic_controls']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
		
		FluentWait<WebDriver> fWait = new FluentWait<>(driver);
		fWait.withTimeout(Duration.ofSeconds(20));
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.ignoring(NoSuchElementException.class);
		
		fWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		
		WebElement entry = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		entry.sendKeys("Hello");
		
		if(entry.getAttribute("value").equals("Hello")) {
			System.out.println("HW2 --> Entry is verified successfully!");
		}else {
			System.out.println("HM2 --> Entry not verified!!!");
		}
		
		Thread.sleep(2000);
		
		tearDown();
	}

}
