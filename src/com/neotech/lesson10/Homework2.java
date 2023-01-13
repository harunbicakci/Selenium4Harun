package com.neotech.lesson10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Homework2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC: Delete Orders
		 * 
		 * 1) Open chrome browser 
		 * 2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
		 * 3) Login to the application 
		 * 4) Click on the checkbox of all orders with product FamilyAlbum 
		 * 5) Delete Selected orders 
		 * 6) Verify the orders have been deleted 
		 * 7) Quit the browser
		 */
		
		setUp();
		
		
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		//get column 3 of the table to use it for condition
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[3]"));
		
		for (int i = 0; i < rows.size(); i++)
		{
			String text = rows.get(i).getText();
			System.out.println("Column 3 text: " + text);
			
			if (text.equals("FamilyAlbum"))
			{
				//click on the checkbox
				String path = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[ "+ (i+2) +"]/td[1]";
				driver.findElement(By.xpath(path)).click();
			}
			
		}
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
		Thread.sleep(2000);
		
		
		tearDown();	
	}
}
