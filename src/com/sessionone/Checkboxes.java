package com.sessionone;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkboxes {

	private static final List<WebElement> WebElement = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.navigate().to(
				"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete11%2fweborders%2f");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys("Tester");// user name
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_password']")).sendKeys("test");// password
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_login_button']")).click();// login
		chrome.findElement(By.linkText("View all orders")).click();// view all orders
		WebElement check = chrome.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
		List<WebElement> Allelements = chrome
				.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]"));
		for (WebElement w1 : Allelements) {
			System.out.println(w1.getText());
		} 
			// findelements if we want to fetch bulk of elements and stores it in a list,
			// type of that element is WebElement. Once we have the list we iterate over
			// each elements using for each loop

		boolean b1 = check.isSelected();
		if (b1 == true) {

			System.out.println("Is the checkbox selected?" + b1);

		} else {
			check.click();

		}

		/*
		 * WebElement test=chrome.findElement(By.xpath(
		 * "//*[@id=\"ctl00_MainContent_orderGrid_ctl02_OrderSelector\"]")); Select
		 * s1=new Select(test); s1.s
		 */

	}
}
