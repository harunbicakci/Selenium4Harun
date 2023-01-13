package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class DynamicTable extends BaseClass {

	public static void main(String[] args) {
		//https://hrm.neotechacademy.com/
		
		
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//navigate to employee list
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.linkText("Employee List")).click();
		
		//lets find all rows that include Linda
		
		String expected ="Linda";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
		

		for (int i =0; i < rows.size();i++)//looping through the rows
		{
			String rowText = rows.get(i).getText(); //get the text of the row
			System.out.println(rowText);
			
			if(rowText.contains(expected))
			{
				//if the full row is clickable we would say: rows.get(i).click();
				
				//1st way:
				//if we are within this condition it means we have found Linda
				//we need to get the 1st or the 2nd column to click on it
				
	//			driver.findElements(By.xpath("//table[@id='employeeListTable']//td[2]")).get(i).click();
						
				//2nd
				List<WebElement> firstColumns = driver.findElements(By.xpath("//table[@id='employeeListTable']//td[1]"));
				firstColumns.get(i).click();
				break;
			}
			
		}
		
		tearDown();
		
	}
}
