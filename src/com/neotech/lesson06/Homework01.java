package com.neotech.lesson06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Homework01 extends BaseClass{
	
//	Amazon Department List Verification
//	Open chrome browser
//	Go to "http://amazon.com/"
//	Verify how many department options available.
//	Print each department 
//	Select Computers
//	Quit browser

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		WebElement departments = driver.findElement(By.id("searchDropdownBox"));
		Select dep = new Select(departments);
		List<WebElement> depList = dep.getOptions(); 
		
		System.out.println("The number of departments are --> " + depList.size() + "\nAnd the departmenst one by one are -->\n");
		for(WebElement el : depList) {
			System.out.println(el.getText());
		}
		Thread.sleep(2000);
		System.out.println("-----------------------------");
		
		dep.selectByVisibleText("Computers");
		Thread.sleep(2000);
		
		tearDown();
		
	}

}
