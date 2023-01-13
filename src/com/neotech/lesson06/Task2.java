package com.neotech.lesson06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Task2 extends BaseClass{

	// Go to http://uitestpractice.com/Students/Form
	// Check Single
	// Select all the Hobbies
	// See if they are selected after you select each of them
	
	public static void main(String[] args) throws InterruptedException {
	
		setUp();
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[3]/label[3]")).click();
		
		List<WebElement> hobbies = driver.findElements(By.xpath("//label[@class='checkbox-inline']"));
		
		for ( WebElement el : hobbies) {
			el.click();
			if(el.isSelected()) {
				System.out.println("The hobbie " + el.getText() + " is selected.");
			}else {
				System.out.println("Test failed. Hobbie --> " + el.getText() + " is NOT selected.");
			}
			Thread.sleep(1000);
		}

		
		
		Thread.sleep(2000);
		
//		tearDown();
		
	}
}
