package com.neotech.lesson15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.BaseClass;

public class Task1501PageUsingFactory {

	@FindBy (xpath = "//body//div//input[@name='txtUsername']")
	public WebElement username;
	
	@FindBy (xpath = "//body//div//input[@name='txtPassword']")
	public WebElement password;
	
	@FindBy (xpath = "//body//div//button[@type='submit']")
	public WebElement loginBtn;
	
	
	
	public Task1501PageUsingFactory() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
