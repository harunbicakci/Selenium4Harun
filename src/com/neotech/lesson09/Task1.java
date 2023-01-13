package com.neotech.lesson09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Task1 extends BaseClass {

	public static void main(String[] args) {

		/*
		 * TC 1: Table headers and rows verification
		 * 
		 * Open chrome browser 
		 * Go to "https://www.techlistic.com/p/demo-selenium-practice.html" 
		 * Verify table contains "Financial Center". 
		 * Print name of all column headers 
		 * Print data of all rows 
		 * 
		 * Quit Browser
		 */
		setUp();
		
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		
		String expected = "Financial Center";
		String actual = table.getText();
	//	System.out.println(actual);
		
		if (actual.contains(expected))
		{
			System.out.println(expected + " is in the table. Test passed!");
		}
		else
		{
			System.out.println(expected + " is not in the table. Test failed!");
		}
		
		
		
		System.out.println("---All Column Headers---");
		
		List<WebElement> headerData = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th"));
		
		for (WebElement data : headerData)
		{
			System.out.print(data.getText() + " | ");
		}
		System.out.println();
		
		
		System.out.println("---All Row Data----");
		
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
				
		for(WebElement data : rowData)
		{
			System.out.println(data.getText());
		}
		
		
		
		tearDown();
		
	}


}
