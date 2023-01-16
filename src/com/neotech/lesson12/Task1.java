package com.neotech.lesson12;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

public class Task1 extends CommonMethods{

	public static void main(String[] args) {
		
//		Open chrome browser
//		Go to https://demo.guru99.com/test/drag_drop.html
//		Drag the following blocks in different ways
//		Drag BANK to DEBIT SIDE
//		Drag SALES to CREDIT SIDE
//		Drag 5000 to DEBIT SIDE
//		Drag 5000 to CREDIT SIDE
//		Close the browser
		
		setUp();
		
		Actions action = new Actions(driver);
		
		WebElement drag5000 = driver.findElement(By.xpath("//li[@data-id='2']"));
		WebElement debitSide = driver.findElement(By.xpath("//ol[@class='field13 ui-droppable ui-sortable'][1]"));
		action.dragAndDrop(drag5000, debitSide).perform();
		wait(1);
		WebElement creditSide = driver.findElement(By.xpath("//ol[@id='amt8']"));
		action.dragAndDrop(drag5000, creditSide).perform();
		wait(1);
		WebElement bankDrag = driver.findElement(By.xpath("//li[@data-id='5']"));
		WebElement bankDrop = driver.findElement(By.xpath("//ol[@id='bank']"));
		action.dragAndDrop(bankDrag, bankDrop).perform();
		wait(1);
		WebElement salesDrag = driver.findElement(By.xpath("//li[@data-id='6']"));
		WebElement salesDrop = driver.findElement(By.xpath("//ol[@id='loan']"));
		action.dragAndDrop(salesDrag, salesDrop).perform();
		wait(1);
		action.keyDown(" ").perform();
		wait(1);
		
		WebElement result = driver.findElement(By.xpath("//div[@class='table4_result']/a"));
		if(result.isDisplayed()) {
			System.out.println("Message displayed --> " + result.getText());
		}else {
			System.out.println("Message NOT displayed!");
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver; // get camera
		File sourceFile = ts.getScreenshotAs(OutputType.FILE); // take screenshot
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/HomeworkScreenshots/screenshot01.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		wait(1);
		tearDown();
	}

}
