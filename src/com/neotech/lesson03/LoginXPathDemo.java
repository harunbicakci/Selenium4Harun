package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginXPathDemo {

	public final static String url = "http://sis.neotechacademy.com:9000/Test/";
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		
		//full xpath for username:
//		/html/body/form/table[1]/tbody/tr/td[2]/table[2]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[3]/input
	//	driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td[2]/table[2]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[3]/input")).sendKeys("Admin");
		
		//relative xpath for username:
		//*[@id='tUsername']
		driver.findElement(By.xpath("//*[@id='tUsername']")).sendKeys("Admin");
		
		//*[@id=\"tUsername\"]
		
		//lets create our own custom xpath for password
		driver.findElement(By.xpath("//input[@name='tPassword'] ")).sendKeys("Neotech$123");
		
		Thread.sleep(3000);
		//lets click on submit
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(3000);
		//lets try to click on students link
		
		//this is the relative xpath
		//*[@id="form1"]/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[6]/a
		
		//customized xpath
		//a[contains(text(), 'Students')]
		driver.findElement(By.xpath("//a[contains(text(), 'Students')]")).click();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
