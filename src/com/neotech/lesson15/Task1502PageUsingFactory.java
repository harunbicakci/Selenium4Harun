package com.neotech.lesson15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.BaseClass;

public class Task1502PageUsingFactory {

	@FindBy (xpath = "//div[@class='input-field']/preceding-sibling::div/input")
	public WebElement username;
	
	@FindBy (xpath = "//div[@class='input-field'][2]/img/following-sibling::input")
	public WebElement password;
	
	@FindBy (xpath = "//div[@class='input-field'][2]/following-sibling::div/button")
	public WebElement loginBtn;
	
	
	public Task1502PageUsingFactory() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
