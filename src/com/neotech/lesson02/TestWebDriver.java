package com.neotech.lesson02;

public class TestWebDriver {

	public static void main(String[] args) {
		
		I_WebDriver driver = new C_SafariDriver();
		
		driver.get("https://www.neotech.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
	}
	
}
