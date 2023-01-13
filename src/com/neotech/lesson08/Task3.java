package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Task3 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
//        Add Employee
//        Open chrome browser
//        Go to "https://hrm.neotechacademy.com/"
//        Login into the application
//        Click on PIM > Add Employee 
//        Add Employee
//        Log out 
//        Quit the browser
		
		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href=\'#/pim/addEmployee\']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys("Jan");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys("Frodeno");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='employeeId']")).clear();		
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys("6123");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@data-id='location']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='New York Sales Office']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"account-job\"]/i")).click();
		Thread.sleep(500);
		driver.findElement(By.id("logoutLink")).click();
		Thread.sleep(2000);
		
		tearDown();
	}

}
