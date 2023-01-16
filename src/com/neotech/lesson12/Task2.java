package com.neotech.lesson12;

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

public class Task2 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
//		Go to https://hrm.neotechacademy.com/
//		Log in using our custom methods
//		Go to PIM menu
//		Add an employee
//		Go to Employee List
//		Get the list of the employees (Using tables - tr and td) 
//		Loop to search for the employee you added
//		When you find the employee - click on it.
//		Take a screenshot
		
		String name = "Lebron";
		String lastName = "James";
		Integer empIdNo = 987655;
		
		setUp();
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/a/span[3]")).click();
		wait(1);
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		wait(2);
		sendText(driver.findElement(By.id("first-name-box")), name);
		wait(1);
		sendText(driver.findElement(By.id("last-name-box")), lastName);
		wait(1);
		sendText(driver.findElement(By.id("employeeId")), empIdNo.toString());
		empIdNo++;
		wait(1);
		click(driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")));
		wait(1);
		click(driver.findElement(By.id("bs-select-1-18")));
		wait(1);
		click(driver.findElement(By.id("modal-save-button")));
		wait(1);
		click(driver.findElement(By.xpath("//*[@id=\"pimPersonalDetailsForm\"]/materializecss-decorator[8]/div/sf-decorator/div/button")));
		wait(2);
		click(driver.findElement(By.xpath("//span[text()='Employee List']")));
		
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td"));
		wait(1);
		for(WebElement cell : table) {
			if(cell.getText().contains(name)) {
				cell.click();
				Thread.sleep(300);
				break;
			}
		}
		wait(2);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/HomeworkScreenshots/screenshot02.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		tearDown();
	}

}
