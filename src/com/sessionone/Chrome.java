package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Chrome {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
	
		WebDriver chrome=new ChromeDriver();
		
		chrome.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete11%2fweborders%2f");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_password']")).sendKeys("test");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_login_button']")).click();
		chrome.findElement(By.xpath("//*[contains(@href,'Process')]")).click();
		
		WebElement test= chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
		Select s1=new Select(test);//
		//s1.selectByVisibleText("FamilyAlbum");// visible to UI
		//s1.selectByValue("MyMoney");// value taken from dom besides value
		s1.selectByIndex(0);
		chrome.navigate().back();
	int x,y;
	x=4;
	y=2;
	
	String w1=	"//*[@id='ctl00_MainContent_orderGrid']/tbody/tr["+x+"]/td["+y+"]";
	
	//chrome.findElement(By.xpath(w1)).getText();
	System.out.println(chrome.findElement(By.xpath(w1)).getText());
	
	
			
		/*chrome.get("https://orderdev.alonti.com/");
		System.out.println("getclass of an object is " + chrome.getClass());
		System.out.println("Page source is " + chrome.getPageSource());
	    System.out.println("Currenturl is " + chrome.getCurrentUrl());	
	    System.out.println("Title of the page is " + chrome.getTitle());
		chrome.navigate().refresh();
		chrome.findElement(By.id("geoCode")).sendKeys("77089");
		Thread.sleep(3000);
		chrome.findElement(By.xpath("//*[@class='btn orange  rounded-0 white']")).click();
		Thread.sleep(3000);
		chrome.findElement(By.xpath("//*[contains(@href,'.com/breakfast')]")).click();
		chrome.navigate().back();
		chrome.navigate().forward();
		chrome.close();
				*/
	
	}

}
