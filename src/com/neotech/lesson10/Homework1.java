package com.neotech.lesson10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Homework1 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * TC: Update Customer Information
		 * 
		 * 1) Open chrome browser 2) Go to
		 * "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
		 * 3) Login to the application 4) Verify customer "Susan McLaren" is present in
		 * the table 5) Click on customer details 6) Update customers last name and
		 * credit card info 7) Verify updated customers name and credit card number is
		 * displayed in table 8) Close browser
		 */

		setUp();

		// login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		// verify susan is there
		// 1st way: locate the table, convert to string, check if it contains Susan

		// since we have to click on the row of Susan, I want to get all the rows of the
		// table

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		int rowIndex = -1;
		// list of size 6
		// what is the last index I can access? 5

		// check all the records one by one if they contain Susan
		for (int i = 1; i < rows.size(); i++) {
			rowIndex = i + 1;
			String rowText = rows.get(i).getText();

			// check if Susan is in this rowText
			if (rowText.contains("Susan McLaren")) {
				System.out.println("Susan found!!!");

				System.out.println("i --> " + i);

				// click on order details

				String path = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + rowIndex + "]/td[13]";

				driver.findElement(By.xpath(path)).click();
				break;

			}

		}
		Thread.sleep(2000);
		// update customer info
		WebElement cName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
		String textInside = cName.getAttribute("value");
		System.out.println("Current Name: " + textInside);

		cName.clear();
		cName.sendKeys("Susan Doe");
		Thread.sleep(1000);

		WebElement card = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
		card.clear();
		card.sendKeys("43878457834758374");

		// update info
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

		Thread.sleep(3000);

		// verify that name is changed
		String newName = driver
				.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + rowIndex + "]/td[2]"))
				.getText();
		System.out.println("newName --> " + newName);

		tearDown();

	}

}
