package com.neotech.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.pages.LambdaRegisterPage;
import com.neotech.utils.CommonMethods;

public class LambdaTest extends CommonMethods{

	public static void main(String[] args) {

		
		/*
		 * Go to https://accounts.lambdatest.com/register 
		 * Find the Password Element and enter a password 
		 * Find the Show span as a nephew of the password element and click on it 
		 * Find the Business Email as a cousin of the password element and
		 * enter an email 
		 * Close the browser
		 */
		setUp();
		LambdaRegisterPage register = new LambdaRegisterPage();
		
	//	WebElement passwordBox = driver.findElement(By.id("userpassword"));
		sendText(register.passwordBox, "test123");
		
		
//		WebElement show = driver.findElement(By.xpath("//input[@id='userpassword']/following-sibling::div/span"));
		jsClick(register.show);
		
		
//		WebElement businessEmail = driver.findElement(By.xpath("//input[@id='userpassword']/../../preceding-sibling::div[1]/input"));

		sendText(register.businessEmail,"murat@neotech.com");
		
		wait(2);
		
		tearDown();
	}

}
