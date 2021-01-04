package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Radiobutton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		chrome.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete11%2fweborders%2f");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_password']")).sendKeys("test");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_login_button']")).click();
		chrome.findElement(By.xpath("//*[contains(@href,'Process')]")).click();
		WebElement test= chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));// For drop downs we need to use webelements
		Select s1=new Select(test);// create an object and pass the dropdowns location as a parameter
		s1.selectByIndex(2);//now use the object created and select what method you want? index/visible text/value
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$txtQuantity')]")).sendKeys("1");
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$txtName')]")).sendKeys("Safia Syed Ismail");
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$TextBox2')]")).sendKeys("HBR Layout");
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$TextBox3')]")).sendKeys("Bengaluru");
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$TextBox4')]")).sendKeys("Karnataka");
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$TextBox5')]")).sendKeys("560043");
		chrome.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();//radio button master card
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$TextBox6')]")).sendKeys("2720992289632526");//cc number
		chrome.findElement(By.xpath("//*[contains(@name,'ctl00$MainContent$fmwOrder$TextBox1')]")).sendKeys("12/20");
		chrome.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
		
		
	}

}
