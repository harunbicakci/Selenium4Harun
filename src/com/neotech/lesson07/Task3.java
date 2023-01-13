package com.neotech.lesson07;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Task3 extends BaseClass{

//	1) Launch the browser and open the site "https://www.tutorialspoint.com/selenium/selenium_automation_practice"
//	2) Fill in the all text boxes, Choose your preferred radio button, 
//	check box and drop down option EXCEPT Profile Picture (Dissmiss this Section)
//	3) Click on the Button and you will see an Alert pops up then click Ok
//	4) When user clicks on Ok new Window will open then get All window handles and get the size and Quit all of them
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		driver.findElement(By.name("firstname")).sendKeys("Albert");
		driver.findElement(By.name("lastname")).sendKeys("Einstein");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[6]/div/form/table/tbody/tr[5]/td[2]/input")).sendKeys("08/23/2023");
		driver.findElement(By.xpath("//input[@value='Automation Tester']")).click();
		driver.findElement(By.xpath("//input[@value='Selenium IDE']")).click();
		driver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		
		WebElement continents = driver.findElement(By.xpath("//select[@name='continents']"));
		Select sel = new Select(continents);
		sel.selectByVisibleText("North America");
		
		WebElement selCommands = driver.findElement(By.name("selenium_commands"));
		Select multSel = new Select(selCommands);
		List<WebElement> options = multSel.getOptions();
		for(int i = 0; i < options.size(); i++) {
			multSel.selectByIndex(i);
			Thread.sleep(1000);
		}
		
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(1000);

		Set<String> handles = driver.getWindowHandles();
		System.out.println("There are " + handles.size() + " windows open.");
		
		tearDown();
	}

}
