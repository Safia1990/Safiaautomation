package com.sessionone;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lastsession {
	
	WebDriver chrome;
	
	//Annotation- identifiers of java @ignore@override
@Before
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
	 chrome=new ChromeDriver();
		
	}
	@Test	
public void 	Open()
	{
		
		chrome.navigate().to("https://orderdev.alonti.com/");	
		String s1="Softway";
		String s2="India";
		assertEquals(s1, s2);
	}
	@Test
	public void open1()
	{
		chrome.navigate().to("https://google.com/");
	}
@After
public void Teardown() {
	chrome.close();
}



}
//it doesn't have main method so using @ will work- @Test, *@before, @after, Assertion method- assert true
//Go through annotations
// Find elements