package com.neotech.lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

public class Homework1 extends CommonMethods {

	public static void main(String[] args) {

		/*
		 * Homework 1: Open chrome browser 
		 * Go to https://demo.guru99.com/test/drag_drop.html 
		 * Drag the following blocks in
		 * different ways 
		 * Drag BANK to DEBIT SIDE 
		 * Drag SALES to CREDIT SIDE 
		 * Drag 5000 to DEBIT SIDE 
		 * Drag 5000 to CREDIT SIDE 
		 * Close the browser
		 */
		
		
		setUp();
		
		//Element (Bank) which we need to drag
		WebElement from1 = driver.findElement(By.id("credit2"));
		
		//Element (Debit Side) where to drop
		WebElement to1 = driver.findElement(By.id("bank"));
		
		
		//Element (Sales) which we need to drag
		WebElement from2 = driver.findElement(By.id("credit1"));
		
		//Element (Credit side) where to drop
		WebElement to2 = driver.findElement(By.id("loan"));
		
		
		//Element (5000) which we need to drag
		WebElement from3 = driver.findElement(By.id("fourth"));
		
		//Element (Debit Side) where we need to drop
		WebElement to3 = driver.findElement(By.id("amt7"));
		
		//Element (5000) 
		//do I need to create
		
		
		//Element (Credit Side) where to drop
		WebElement to4 = driver.findElement(By.id("amt8"));
		
		
		Actions act = new Actions(driver); 
		
		//Drag Bank and drop
		act.dragAndDrop(from1, to1).perform();
		
		
		wait(1);
		
		act.dragAndDrop(from2, to2).perform();
		
		wait(1);
		
		act.clickAndHold(from3).moveToElement(to3).release().perform();
		
		wait(1);
		
		act.dragAndDrop(from3, to4).perform();
		
		
		//verify that Perfect is shown
		if (driver.findElement(By.linkText("Perfect!")).isDisplayed())
		{
			System.out.println("Perfect is Displayed");
		}
		else
		{
			System.out.println("Perfect is NOT Displayed");
		}
		
		
		wait(1);
		
		tearDown();
	}

}
