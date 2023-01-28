package com.neotech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

public class DashboardPage extends CommonMethods{

	public WebElement logo = driver.findElement(By.id("ohrm-small-logo"));
	
	public WebElement name = driver.findElement(By.id("account-name"));
	
}
