package com.neotech.lesson12;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class ScreenShotDemo extends CommonMethods {

	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/
		
		setUp();
		
		//we can use sendKeys() and/or .click() but we want to use our methods
		
		sendText(driver.findElement(By.id("txtUsername")), 
				ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),
				ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait(4);
		
		//create an object of TakesScreenshot (in fact we are downcasting)
		TakesScreenshot ts = (TakesScreenshot) driver; //get the camera 
		
		
		//take the screenshot
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		//save it somewhere
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/HRM/screenshot01.png"));
		
		//in one line
	//	FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), 
	//			new File("screenshots/HRM/screenshot01.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("We did NOT take a screenshot!!!");
		}
		
		

		tearDown();
		

	}

}
