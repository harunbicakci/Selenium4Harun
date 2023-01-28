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

public class Task3 extends CommonMethods{

	public static void main(String[] args) {

//		Homework 3: 
//		Go to url: https://hrm.neotechacademy.com/
//		Log in using our custom methods
//		Go to PIM menu
//		Add an employee
//		Upload another image in the employee photo

		setUp();
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(2);
		
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		click(driver.findElement(By.linkText("Add Employee")));
		
		sendText(driver.findElement(By.id("first-name-box")), "Ibo");
		sendText(driver.findElement(By.id("last-name-box")), "Show");
		selectDropDown(driver.findElement(By.id("location")),"German Regional HQ");
		wait(1);
		click(driver.findElement(By.id("modal-save-button")));
		wait(1);
		click(driver.findElement(By.xpath("//img[@class='circle profile-photo valign tooltipped']")));
		wait(2);
		String filePath = System.getProperty("user.dir") + "/screenshots/ibo.png";
		sendText(driver.findElement(By.id("employeePicture")), filePath);
		click(driver.findElement(By.xpath("//*[@id='updatePhotoModal']/form/div[2]/a[1]")));
		wait(3);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("screenshots/HomeworsScreenshots/hw03.png"));
			System.out.println("Screenshot successfully saved to folder!");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot NOT taken!");
		}
		wait(1);
		tearDown();
	}

}
