package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {

	public static String url = "https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407";
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement maleRB = driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_0']"));
		maleRB.click();
		Thread.sleep(3000);
		
		WebElement femaleRB = driver.findElement(By.cssSelector("label[for='RESULT_RadioButton-7_1']"));
		femaleRB.click();
		Thread.sleep(3000);
		
		WebElement mondayCB = driver.findElement(By.cssSelector("label[for='RESULT_CheckBox-8_1']"));
		mondayCB.click();
		
		// 2nd way
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='inline_grid choices']/tbody/tr/td/label"));
		
		// we want to click on female radio buttons, and on Monday and Wednesday checkboxes
		
		for ( WebElement el : elements) {
			String text = el.getText();
			
			if (text.equals("Female")) {
				el.click();
				Thread.sleep(3000);
			} else if (text.equals("Monday")) {
				el.click();
				Thread.sleep(3000);
			} else if (text.equals("Wednesday")) {
				el.click();
				Thread.sleep(3000);
			}
		}
		
		
		
		
		
		driver.quit();
	}

}
