package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elementvisibilitytest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		chrome.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete11%2fweborders%2f");
		chrome.manage().window().maximize();
		chrome.findElement(By.id("ctl00_MainContent_username")).sendKeys(Keys.ENTER);//user name
		chrome.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");	//password	
	boolean b1=	chrome.findElement(By.id("ctl00_MainContent_login_button")).isDisplayed();//login button
	System.out.println("Is login button displayed?" + b1);
	    chrome.findElement(By.id("ctl00_MainContent_login_button")).click();//login
	    chrome.findElement(By.linkText("Order")).click();//orders page
	boolean b2=chrome.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).isEnabled();//Process button
	System.out.println("Is the button enabled?" + b2);
	    //chrome.close();
	    WebElement sel=chrome.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));//created a web element for radio button
	boolean b3=  sel.isSelected();//stored the same in variable b3
	if(sel.isSelected())//checking if its selected?
	{
		System.out.println("Is the radio button selected?" +b3);//based on that
	    	

	}
	else
	{
		sel.click();//select it
	}
	
	

}
}
