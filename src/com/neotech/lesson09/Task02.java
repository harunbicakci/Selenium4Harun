package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Task02 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

//		Delete Orders
//		1) Open chrome browser
//		2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
//		3) Login to the application
//		4) Click on the checkbox of all orders with product FamilyAlbum
//		5) Delete Selected orders
//		6) Verify the orders have been deleted
//		7) Quit the browser

		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		String expected = "FamilyAlbum";
		
		for(int i = 1; i < rows.size(); i++) {
			
			if(rows.get(i).getText().contains(expected)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + (i + 1) + "]/td")).click();
				Thread.sleep(500);
			}
		}
		
		driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
		Thread.sleep(2000);
		
		WebElement table = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody"));
		
		if(table.getText().contains(expected)) {
				System.out.println("TEST FAILED! --> " + expected + " <-- still remains.");
		}else {
			System.out.println("TEST PASSED! --> " + expected + " <-- is deleted.");
		}
		
		tearDown();
	}

}
