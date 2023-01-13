package com.neotech.lesson08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Homework2 extends BaseClass {
//	=================   HW_2_Handling Frames =================================
//
//	1) Launch the browser and open the site "https://chercher.tech/practice/frames-example-selenium-webdriver"
//	2) Verify on the page header "Not a Friendly Topic" displayed
//	3) Click on the Inner Frame Check box
//	4) Choose baby Cat from Animals dropdown
//	5) Quit the browser

	public static void main(String[] args) throws InterruptedException {

		setUp();

		// To locate the label in the main page, and getting the text
		String label = driver.findElement(By.xpath("//body[@id='page-top']//label")).getText();
		System.out.println(label);

		// Moving inside the first frame
		driver.switchTo().frame("frame1");

		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(innerFrame);

		// Switching by index
		// driver.switchTo().frame(0);

		// Switching by ID or Name
		// driver.switchTo().frame("frame3");

		// Now you are inside the inner frame
		driver.findElement(By.id("a")).click();

		Thread.sleep(2000);

		// Switch the focus to the main page
		driver.switchTo().defaultContent();

		// Switching to the frame by using index
		driver.switchTo().frame(1);

		Select sel = new Select(driver.findElement(By.id("animals")));
		sel.selectByVisibleText("Baby Cat");
		Thread.sleep(2000);

		tearDown();
	}


}
