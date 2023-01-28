package com.neotech.lesson13;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework2 extends CommonMethods {

	public static void main(String[] args) {

		/*
		 * Homework 2: Go to https://hrm.neotechacademy.com/ Log in using our custom
		 * methods Go to PIM menu Add an employee Go to Employee List Get the list of
		 * the employees (Using tables - tr and td) Loop to search for the employee you
		 * added When you find the employee - click on it. Take a screenshot
		 */

		setUp();

		// login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button[@type='submit']")));

		// navigate to PIM
		click(driver.findElement(By.id("menu_pim_viewPimModule")));

		// click on Add Employee
		click(driver.findElement(By.linkText("Add Employee")));

		// send new employee data
		sendText(driver.findElement(By.id("first-name-box")), "Osman");
		sendText(driver.findElement(By.id("last-name-box")), "Mohamed");

		// select dropdown
		selectDropDown(driver.findElement(By.id("location")), "Australian Regional HQ");

		// get the id so that we can search the employee
		String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("EmpID: " + empId);

		wait(2);

		// it includes waitForClickabilit
		click(driver.findElement(By.id("modal-save-button")));

		// wait until employee personal details are shown
		waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));

		// we can take a screenshot in this moment

		click(driver.findElement(By.linkText("Employee List")));

		boolean found = false;

		while (!found) {
			wait(2);

			// get all id's on this page
			List<WebElement> idList = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[2]"));

			// we need to check each id if it is the id of the new employee
			for (WebElement el : idList) {
				// check if the id is equal
				String currentId = el.getText();
				if (currentId.equals(empId)) {
					found = true;
					el.click();
					break;
				}
			}

			// If I don't find the employee on this page, I'll check next page
			if (!found) {
				System.out.println("I will check on the next page!");
				driver.findElement(By.xpath("//i[text()='chevron_right']")).click();
			}

		}

		// wait for the form to show
		waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));

		// take a screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/Lesson13/Homework2.png"));
		} catch (IOException e) {
			System.out.println("Screenshot was not saved...");
		}

		wait(2);

		tearDown();

	}

}
