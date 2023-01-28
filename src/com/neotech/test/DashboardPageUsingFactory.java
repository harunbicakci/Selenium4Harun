package com.neotech.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.BaseClass;

public class DashboardPageUsingFactory {

	// Create the DashboardPageUsingFactory similar to LoginPageUsingFactory
	// Find logo WebElement using @FindBy annotation
	// Use the logo variable here in this class
	
	@FindBy ( id = "ohrm-small-logo")
	public WebElement logo;
	
	@FindBy(id = "account-name")
	public WebElement name;
	
	public DashboardPageUsingFactory() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
}
