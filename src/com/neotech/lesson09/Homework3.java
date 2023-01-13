package com.neotech.lesson09;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Homework3 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Add Employee 
		 * Open chrome browser 
		 * Go to "https://hrm.neotechacademy.com/"
		 * Login into the application 
		 * Click on PIM > Add Employee 
		 * Add Employee 
		 * Log out
		 * Quit the browser
		 */

		setUp();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		
		//navigate to PIM menu
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		//click on Add employee
		driver.findElement(By.linkText("Add Employee")).click();
		
		//send employee data
		driver.findElement(By.id("first-name-box")).sendKeys("test001");
		driver.findElement(By.id("last-name-box")).sendKeys("test001");
		
		//get the select element 
		WebElement sl = driver.findElement(By.id("location"));
		Select s = new Select(sl);
		s.selectByVisibleText("France Regional HQ");
		
		
	//	Thread.sleep(3000);
		
		//driver.findElement(By.id("modal-save-button")).click();
		//the save button needs to be active
		
		WebElement saveBtn = driver.findElement(By.id("modal-save-button"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		
		saveBtn.click();
		
		//wait for the add employee to be done
		//we can use WebDriverWait as well
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(10));
		fluentWait.pollingEvery(Duration.ofSeconds(1));
		
		//we an ignore a possible expection
		fluentWait.ignoring(ElementClickInterceptedException.class);
		
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_details_tab")));
		
		driver.findElement(By.id("account-job")).click();
		driver.findElement(By.id("logoutLink")).click();
		
		tearDown();
		
		
	}
}
