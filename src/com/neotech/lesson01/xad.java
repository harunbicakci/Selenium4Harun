package com.neotech.lesson01;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xad {
	public static void main(String[] args) throws InterruptedException {
		// which browser I want to use
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.youtube.com/watch?v=1zby0XK63Wo&list=RDGMEMJQXQAmqrnmK1SEjY_rKBGA&start_radio=1&rv=NeQM1c-XCDc");

		String actualURL = driver.getCurrentUrl();
		String expectedURL = ("https://www.youtube.com/watch?v=1zby0XK63Wo&list=RDGMEMJQXQAmqrnmK1SEjY_rKBGA&start_radio=1&rv=NeQM1c-XCDc");

		if (actualURL.equalsIgnoreCase(expectedURL)) {
			System.out.println("Title = " + driver.getTitle());
		} else {
			System.out.println("The URL is wrong!");
		}

		WebElement videoPlayer = driver.findElement(By.id("movie_player"));

		videoPlayer.click();

		videoPlayer.sendKeys("F");

		// Thread.sleep(5000);

		// driver.close();

	}
}
