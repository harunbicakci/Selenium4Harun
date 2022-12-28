package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Homework03 extends BaseClass{

//    Open chrome browser
//    Go to "https://semantic-ui.com/modules/dropdown.html"
//    Scroll down to "Multiple Selection"
//    Click on drop down and select "CSS" and "HTML"
//    Verify value has been selected
//    Deselect 1 of the options from the dropdown
//    Quit browser
    
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		WebElement multSel = driver.findElement(By.xpath("//div[@class='ui fluid dropdown selection multiple']"));
		multSel.click();
		WebElement multSelCSS = driver.findElement(By.xpath("//div[@data-value='css']"));
		multSelCSS.click();
		WebElement multSelHTML = driver.findElement(By.xpath("//div[@data-value='html']"));
		multSelHTML.click();
		Thread.sleep(2000);
		
		WebElement CSSSel = driver.findElement(By.xpath("//a[@data-value='css']"));
		WebElement HTMLSel = driver.findElement(By.xpath("//a[@data-value='html']"));
		
		if(CSSSel.isDisplayed()) {
			System.out.println("CSS selection verified");
		}else {
			System.out.println("CSS selection NOT verified");
		}


		if(HTMLSel.isDisplayed()) {
			System.out.println("HTML selection verified");
		}else {
			System.out.println("HTML selection NOT verified");
		}

		driver.findElement(By.xpath("//a[@data-value='css']/i[@class='delete icon']")).click();
		Thread.sleep(2000);
		
		tearDown();
	}
}
