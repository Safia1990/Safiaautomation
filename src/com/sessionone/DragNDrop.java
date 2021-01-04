package com.sessionone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragNDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		chrome.navigate().to("https://id.atlassian.com/login?continue=https%3A%2F%2Fsoftwaysolutions.atlassian.net%2Flogin%3FredirectCount%3D1%26application%3Djira&application=jira");
//chrome.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("xxx@gmail.com");	
chrome.findElement(By.xpath("//*[@id=\"login-submit\"]/span/span/span")).click();
Thread.sleep(3000);
//chrome.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("xdxxxxx456gtf%7#@frtyg+_9*(&");
chrome.findElement(By.xpath("//*[@id=\"login-submit\"]/span/span")).click();
chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
chrome.findElement(By.xpath("//*[@id=\"createGlobalItem\"]")).click();

	}

}
