package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Task2 extends BaseClass{

//	1) Launch the browser and open the site "https://chercher.tech/practice/frames-example-selenium-webdriver"
//	2) Verify on the page header "Not a Friendly Topic" displayed
//	3) Click on the Inner Frame Check box
//	4) Choose baby Cat from Animals dropdown
//	5) Quit the browser

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		WebElement header = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div/div/div/div/div/label/span"));
		System.out.println("Is header displayed? --> " + header.isDisplayed() + " --> " + header.getText());
		
		// switching to 1st frame
		driver.switchTo().frame("frame1");
		
		// switching to child frame --> frame3
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//*[@id='a']")).click();
		
		// switching to main page
		driver.switchTo().defaultContent();
		
		// switching to second frame --> frame2
		driver.switchTo().frame("frame2");
		Thread.sleep(1000);
		
		WebElement dd = driver.findElement(By.id("animals"));
		Select selDD = new Select(dd);
		selDD.selectByIndex(1);
		
		Thread.sleep(2000);

		tearDown();
	}

}
