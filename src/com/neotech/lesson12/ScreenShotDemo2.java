package com.neotech.lesson12;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class ScreenShotDemo2 extends CommonMethods{

	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/
		
		setUp();
		
		//we can use sendKeys() and/or .click() but we want to use our methods
		
		sendText(driver.findElement(By.id("txtUsername")), 
				ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),
				"");
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait(4);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		//take screenshot
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
				
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots2/HRM/screenshot02.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tearDown();

	}

}
