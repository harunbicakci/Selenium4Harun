package com.neotech.lesson02;

public class C_SafariDriver implements I_WebDriver{

	public C_SafariDriver() {
		System.out.println("Opening Safari Browser");
	}
	
	@Override
	public void get(String url) {
		System.out.println("Navigating Safari Browser");		
	}

	@Override
	public String getTitle() {
		System.out.println("Safari gets the title of the page");
		return "Page Title";
	}

	@Override
	public String getCurrentUrl() {
		System.out.println("Safari gets the current URL");
		return "Page URL";
	}

	@Override
	public void close() {
		System.out.println("Safari closing the current tab");
		
	}

	@Override
	public void quit() {
		System.out.println("Safari closing the all tabs");
		
	}

	
	
}
