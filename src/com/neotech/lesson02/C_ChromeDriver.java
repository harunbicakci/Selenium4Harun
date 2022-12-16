package com.neotech.lesson02;

public class C_ChromeDriver  implements I_WebDriver{

	public C_ChromeDriver() {
		System.out.println("Opening Chrome Browser");
	}
	
	@Override
	public void get(String url) {
		System.out.println("Navigating Chrome Browser");		
	}

	@Override
	public String getTitle() {
		System.out.println("Chrome gets the title of the page");
		return "Page Title";
	}

	@Override
	public String getCurrentUrl() {
		System.out.println("Chrome gets the current URL");
		return "Page URL";
	}

	@Override
	public void close() {
		System.out.println("Chrome closing the current tab");
		
	}

	@Override
	public void quit() {
		System.out.println("Chrome closing the all tabs");
		
	}

}
