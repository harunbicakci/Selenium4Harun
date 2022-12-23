package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework4 {

	public static String url = "https://demo.seleniumeasy.com/basic-checkbox-demo.html";

	public static void main(String[] args) throws InterruptedException {

//		===========Extra==========
//		Play with check boxes and radio buttons in these pages
//		https://demo.seleniumeasy.com/basic-checkbox-demo.html
//		https://demo.seleniumeasy.com/basic-radiobutton-demo.html

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// 1 -> Click on 'Check All' to check all checkboxes at once.
		System.out.println("Test no 1:");
		driver.findElement(By.cssSelector("input#isAgeSelected")).click();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//div[@id='txtAge']")).getText();
		System.out.println(text);
		Thread.sleep(1000);

		// 2 -> When you check all the checkboxes, button will change to 'Uncheck All'
		System.out.println("Test no 2:");
		driver.findElement(By.cssSelector("#check1")).click();
		String message = driver.findElement(By.cssSelector("#check1")).getAttribute("value");
		if (message.equals("Uncheck All")) {
			System.out.println("Message test is passed --> " + message);
		} else {
			System.out.println("Message test is failed --> " + message);
		}
		Thread.sleep(1000);

		// 3 -> When you uncheck at least one checkbox, button will change to 'Check All'
		System.out.println("Test no 3:");
		
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")).click();
		String str = driver.findElement(By.id("check1")).getAttribute("value");
		
		if(str.equals("Check All")) {
			System.out.println("Test passed! Text should say \"Check All\" --> " + str);
		} else {
			System.out.println("Test failed! Text should say \"Check All\" --> " + str);
		}
		
		driver.quit();
	}

}
