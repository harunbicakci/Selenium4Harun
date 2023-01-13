package com.neotech.lesson06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class HarryPotterSearch extends BaseClass{

	// Go to https://amazon.com
	// select books from the search dropdown
	// type Harry potter
	// and click on Search
	// check "Kindle Unlimited Eligible" checkbox on the left
	
	public static void main(String[] args) throws InterruptedException {
	
		setUp();
		
		Thread.sleep(1000);
		
		WebElement searchDDElement = driver.findElement(By.id("searchDropdownBox"));
		Select selectDD = new Select(searchDDElement);
		
//		Print all the options of the dropdown
//		List<WebElement> optionList = selectDD.getOptions();
//		for(WebElement option : optionList) {
//			System.out.println(option.getText());
//		}
		
		// there are 3 ways to select on Dropdown options
		selectDD.selectByIndex(4);
		selectDD.selectByValue("search-alias=amazon-devices");
		selectDD.selectByVisibleText("Books");
		
		
		
		
		Thread.sleep(1000);
		
		tearDown();
	}	
}
