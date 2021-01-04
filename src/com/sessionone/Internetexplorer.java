package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Internetexplorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.ie.driver", "lib\\IEDriverServer.exe");
 WebDriver iedrw=new InternetExplorerDriver();
 iedrw.navigate().to("https://orderdev.alonti.com/");
 iedrw.manage().window().maximize();
 iedrw.findElement(By.id("geoCode")).sendKeys("77089");
 iedrw.findElement(By.xpath("//*[@class='btn orange  rounded-0 white']")).click();
 
 
 
	}

}
