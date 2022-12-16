package com.neotech.lesson02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework2 {

	public static void main(String[] args) {

//		HW2: Opening Page on Firefox Browser
//		Open Firefox browser
//		Navigate to “https://www.redfin.com/”
//		Verify that you have navigated to (https://www.redfin.com/)
//		End the Session (close the browser).

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");

		// open firefox driver
		WebDriver driver = new FirefoxDriver();

		String url = "https://www.redfin.com/";
		
		// navigate to the web address
		driver.get(url);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
