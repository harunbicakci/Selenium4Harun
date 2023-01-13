package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class NestedFrames extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		// https://demoqa.com/nestedframes/
		
		setUp();
		
		// switch to frame 1
		// driver.switchTo().frame("frame1");
		// using id
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		
		// switch to child frame
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		// switching to the nested frame using a WelElement
		driver.switchTo().frame(childFrame);
		
		// now we are inside the child frame
		WebElement p = driver.findElement(By.xpath("//body/p"));
		System.out.println("Text inside the child frame: " + p.getText());
		
		Thread.sleep(3000);
		
		// at this point the focus of the driver is in the ChildFrame
		
		// we can switch to the main page
		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		
		tearDown();
	}

}
