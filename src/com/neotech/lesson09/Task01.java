package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Task01 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
//	Update Customer Information
//	1) Open chrome browser
//	2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
//	3) Login to the application
//	4) Verify customer "Susan McLaren" is present in the table
//	5) Click on customer details
//	6) Update customers last name and credit card info
//	7) Verify updated customers name and credit card number is displayed in table
//	8) Close browser
		
		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
		
		String expected = "Susan McLaren";
		String actual = table.getText();
		int num = 0;
		
		if(actual.contains(expected)) {
			System.out.println(expected + " --> is in the table. Test Passed!");
		}else {
			System.out.println(expected + " --> is NOT in the table. Test Failed!");
		}
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		for(int i = 1; i < rows.size(); i++) {
			
			String rowText = rows.get(i).getText();
			
			if(rowText.contains(expected)) {
				num = i + 1;
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + (i+1) + "]/td[13]")).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		String name = "Susan Suzi";
		String ccNo = "1234567891011";
		
		WebElement customerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
		customerName.clear();
		customerName.sendKeys(name);
		Thread.sleep(500);
		
		WebElement cardNr = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
		cardNr.clear();
		cardNr.sendKeys(ccNo);
		Thread.sleep(500);
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		Thread.sleep(2000);
		
		WebElement thatRow = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + (num) + "]"));
		
		if(thatRow.getText().contains(name)) {
			System.out.println("The name --> " + name + " is displayed. Test Passed!");
		}else {
			System.out.println("The name --> " + name + " is NOT displayed. Test Failed!");
		}
		
		if(thatRow.getText().contains(ccNo)) {
			System.out.println("The credit card info --> " + ccNo + " is displayed. Test Passed!");
		}else {
			System.out.println("The credit card info --> " + ccNo + " is NOT displayed. Test Failed!");
		}
		
		Thread.sleep(2000);
		
		tearDown();
	}

}
