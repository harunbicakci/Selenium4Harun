package com.neotech.lesson13;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.neotech.utils.CommonMethods;

public class TaskOne extends CommonMethods{

	public static void main(String[] args) {
		
//		1. Navigate to --> http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload
//		2. Upload file - 3. Verify file got successfully uploaded and take screenshot
		
		setUp();
		
		String imagePath = System.getProperty("user.dir") + "/screenshots/HomeworkScreenshots/screenshot01.png";
		driver.findElement(By.id("gwt-debug-cwFileUpload")).sendKeys(imagePath);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message is --> " + alert.getText());
		wait(1);
		alert.accept();
		wait(1);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("screenshots/HomeworkScreenshots/Upload01.png");
		
		try {
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot successfully saved to folder!");
		}catch(Exception e) {
			System.out.println("Screenshot NOT taken!");
			e.printStackTrace();
		}
		
		
		wait(1);
		tearDown();
	}

}
