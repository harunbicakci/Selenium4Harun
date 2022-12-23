package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {

	public static String url = "http://uitestpractice.com/Students/Form";

	public static void main(String[] args) throws InterruptedException {

//		Radio Button Practice  
//		Open chrome browser
//		Go to "http://uitestpractice.com/Students/Form"
//		Verify if all radio buttons are displayed and clickable
//		Click on all radio buttons
//		Verify radio buttons has been clicked successfully
//		Quit browser

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		List<WebElement> marialStatus = driver.findElements(By.xpath("//input[@type='radio']"));

		for (WebElement each : marialStatus) {
			each.click();
			if (each.isDisplayed() && each.isEnabled()) {
				System.out.println(each.getAccessibleName() + " --> is displayed succesfully and it is clickable.");
			} else {
				System.out.println(each.getAccessibleName() + " --> is not displayed! ");
			}

			Thread.sleep(1000);
		}

		List<WebElement> hobby = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement each : hobby) {
			each.click();
			if (each.isDisplayed() && each.isEnabled()) {
				System.out.println(each.getAccessibleName() + " --> Hobby CheckBox is displayed and clicked.");
			} else {
				System.out.println(each.getAccessibleName() + " --> Hobby CheckBox is not displayed!");
			}
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		driver.quit();
	}

}
