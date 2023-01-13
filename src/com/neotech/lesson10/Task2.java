package com.neotech.lesson10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class Task2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

//		Homework: American Airlines Flight Search
//		Open chrome browser
//		Go to https://www.aa.com/homePage.do
//		Enter From and To
//		Select departure as December 14 of 2022
//		Select arrival as December 22 of 2022
//		Click on search
//		Close browser

		setUp();
		WebElement from = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']"));
		from.clear();
		from.sendKeys("MCO");
		Thread.sleep(400);
		WebElement to = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
		to.clear();
		to.sendKeys("YMQ");
		Thread.sleep(400);

		String targetDepartureMonth = "October";
		String targetDepartureDay = "14";
		String targetArrivalMonth = "October";
		String targetArrivalDay = "22";

		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger'][1]")).click();
		String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month'][1]")).getText();

		while (!actualMonth.equals(targetDepartureMonth)) {
			driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
			Thread.sleep(400);
			actualMonth = driver
					.findElement(
							By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div/span[1]"))
					.getText();
			Thread.sleep(400);
		}
		List<WebElement> departureDays = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar'][1]/tbody/tr/td"));

		for (WebElement day : departureDays) {
			if (day.getText().equals(targetDepartureDay)) {
				day.click();
				Thread.sleep(400);
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm']/div[4]/div[2]/div/button")).click();

		actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month'][1]")).getText();
		while (!actualMonth.equals(targetArrivalMonth)) {
			driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
			Thread.sleep(400);
			actualMonth = driver
					.findElement(
							By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div/span[1]"))
					.getText();
			Thread.sleep(400);
		}
		List<WebElement> arrivalDays = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar'][1]/tbody/tr/td"));
		for (WebElement day : arrivalDays) {
			if (day.getText().equals(targetArrivalDay)) {
				day.click();
				Thread.sleep(400);
				break;
			}
		}
		driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fareCategory_refundable")));
		Thread.sleep(4000);
		tearDown();
	}
}
