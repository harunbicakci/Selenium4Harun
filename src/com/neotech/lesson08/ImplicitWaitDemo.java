package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class ImplicitWaitDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// http://uitestpractice.com/Students/Contact

		setUp();

		// Defining an implicit wait of 30 Seconds
		// this is valid for the lifetime of the driver
		// if the element is not found, it waits up to the maximum time
		// only after the maximum time an exception will be thrown
		// If the element is found before maximum time
		// the execution continues

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("This is a Ajax link")).click();

		// If I use Thread.sleep(10000); I will have to wait for 10 seconds
		// Thread.sleep(10000);

		WebElement div = driver.findElement(By.className("ContactUs"));
		String text = div.getText();
		System.out.println(text);

		tearDown();

	}
}
