package com.neotech.lesson10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Task1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
//		Open chrome browser
//		Go to https://hrm.neotechacademy.com/
//		Login into the application
//		Select Discipline
//		Select Disciplinary Cases
//		Click on Filter (Up-Right next to Help)
//		Select from June 6, 2022 to July 15, 2022
//		Click on Search
//		Validate that there are no rows in result table
//		Quit the browser

		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.clear();
		username.sendKeys(ConfigsReader.getProperty("username"));
		Thread.sleep(500);
		password.clear();
		password.sendKeys(ConfigsReader.getProperty("password"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Discipline']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@combinedmenutitle='Discipline > Disciplinary Cases']")).click();
		Thread.sleep(500);
		
		// switching to frame 
		driver.switchTo().frame("noncoreIframe");
		driver.findElement(By.xpath("//i[text()='ohrm_filter']")).click();
		Thread.sleep(500);
		
		// selecting date from
		driver.findElement(By.xpath("//label[text()='Created Date From']")).click();
		// month
		driver.findElement(By.xpath("//div[@id='DisciplinaryCaseSearch_createdDateFrom_root']//input[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[@id='DisciplinaryCaseSearch_createdDateFrom_root']//li/span[text()='June']")).click();
		Thread.sleep(300);
		// year
		driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']//input[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']//li/span[text()='2022']")).click();
		Thread.sleep(300);
		List<WebElement> table1 = driver.findElements(By.xpath("//table[@id='DisciplinaryCaseSearch_createdDateFrom_table']/tbody/tr/td"));
		for( WebElement day : table1) {
			if(day.getText().equals("6")) {
				day.click();
			}
		}
		Thread.sleep(3000);
		
		// selecting date to
		driver.findElement(By.id("DisciplinaryCaseSearch_createdDateTo_root")).click();
		//month
		driver.findElement(By.xpath("//div[@id='DisciplinaryCaseSearch_createdDateTo_root']//input[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[@id='DisciplinaryCaseSearch_createdDateTo_root']//span[text()='July']")).click();
		Thread.sleep(300);
		// year
		driver.findElement(By.xpath("//div[@id='DisciplinaryCaseSearch_createdDateTo_root']//input[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("///div[@id='DisciplinaryCaseSearch_createdDateTo_root']//li/span[text()='2022']")).click();
		Thread.sleep(300);
		List<WebElement> table2 = driver.findElements(By.xpath("//table[@id='DisciplinaryCaseSearch_createdDateTo_table']/tbody/tr/td"));
		for( WebElement day : table2) {
			if (day.getText().equals("15")) {
				day.click();
			}
		}
		Thread.sleep(3000);
		
		// clicking search button
		driver.findElement(By.id("searchBtn")).click();
		
		List<WebElement> resultTable = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr"));
		
		System.out.println("The results between choosen dates are: " + resultTable.size());
		
		Thread.sleep(1000);
		 
		tearDown();
	}

}
