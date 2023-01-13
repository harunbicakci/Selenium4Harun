package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Homework3 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Open chrome browser Go to "https://semantic-ui.com/modules/dropdown.html"
		 * Scroll down to "Multiple Selection" Click on drop down and select "CSS" and
		 * "HTML" Verify value has been selected Deselect 1 of the options from the
		 * dropdown Quit browser
		 */

		setUp();
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div")).click();
		Thread.sleep(2000);

		// click on CSS
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/div[2]/div[2]"))
				.click();
		Thread.sleep(2000);

		// click on HTML
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/div[2]/div[5]"))
				.click();
		Thread.sleep(2000);

		
		// before we delete CSS, get the text
		String css_remove_text = driver
				.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/a[1]"))
				.getText();
		System.out.println(css_remove_text);
		// delete on CSS
		driver
		.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/a[1]/i")).click();
		Thread.sleep(2000);

		tearDown();

	}

}
