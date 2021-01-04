package com.sessionone;



import java.awt.Rectangle;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Learn {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
/*
 * 1. Installation
 * 2. Connection
 */

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\safia.syed\\eclipse-workspace\\Seleniumlearning\\lib\\chromedriver.exe");
	WebDriver w1=new ChromeDriver();
	//w1.manage().window().fullscreen();
	w1.manage().window().maximize();//this is to open the window in full size	
	
	/*w1.manage().window().setPosition(new Point(400,200));	
	Point p1=w1.manage().window().getPosition();
	System.out.println(p1);
	
	w1.manage().window().setSize(new Dimension(100,200));	
	Dimension d1=w1.manage().window().getSize();
	System.out.println(d1);*/
	
	
	
	
	w1.navigate().to("https://orderdev.alonti.com/");
	w1.navigate().refresh();
	
   WebElement webele= w1.findElement(By.xpath("//*[@class='btn orange  rounded-0 white']"));
  String s= webele.getText();
  System.out.println(s);
  
 
  
  WebElement webele1= w1.findElement(By.id("geoCode"));
  String s1= webele1.getAttribute("placeholder");
  System.out.println("Get attribute is: "+s1);
  
  WebElement webele2= w1.findElement(By.id("geoCode"));
  String s2= webele1.getTagName();
  System.out.println("Get tag name is: "+s2);
  
  
  WebElement webele3= w1.findElement(By.id("geoCode"));
  Point s3= webele1.getLocation();
  System.out.println("Getposition is: "+s3);
  
  WebElement webele4= w1.findElement(By.id("geoCode"));
  org.openqa.selenium.Rectangle s4= webele1.getRect();
  System.out.println("Getposition is: "+s4);
  w1.close();

	/*w1.findElement(By.xpath("//*[@class=\"form-control d-inline-block  rounded-0\"]")).sendKeys("77089");
	//w1.findElement(By.id("geoCode")).sendKeys("77089");	
	w1.findElement(By.xpath("//html/body/div[2]/div/div/div/section/div/div/a")).click();
	//w1.findElement(By.linkText("Start Your Order")).click();
	Thread.sleep(3000);
	w1.findElement(By.xpath("//html/body/div/section/div/div[2]/a")).click();
	
	//w1.findElement(By.linkText("WARM UP THIS WINTER")).click();
	w1.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div[2]/div/div[2]/div/div[1]/div/div[1]/div[3]")).click();

	w1.findElement(By.xpath("//div[@id=\"add_cart\"]/div/section/div[2]/div[1]/div[2]/div/div[7]/div/div/div/div/div/ul/li/input")).click();
	 
	w1.findElement(By.xpath("//*[@class='ti-new-tag-input ti-valid']")).sendKeys("Safia Syed");
	w1.findElement(By.xpath("//div[@class='notes-options']/div/div[2]/textarea")).sendKeys("Please don't add tomatoes");
	w1.findElement(By.xpath("//div[@id=\"add_cart\"]/div[2]/div/a[2]")).click();//add to cart
	
	try {
		w1.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div[2]/div/div[1]/div/div/div/div[1]/table/tbody/tr[1]/td[5]/div/div/div[1]/div[1]")).click();
		} catch (Exception e) {
		System.out.println("There is a problem please check");
	}
	
	Thread.sleep(3000);
	
	w1.findElement(By.xpath("//*[contains(@href,'alonti.com/summary')]")).click();//checkout
	w1.findElement(By.xpath("//*[contains(@href,'/warm-cookies')]")).click();//add cookies
	w1.findElement(By.xpath("//*[contains(@href,'chocolate-chunk')]")).click();//type of cookie
	w1.findElement(By.xpath("//div[@id='add_cart']/div[2]/div[1]/a[2]")).click();//add to cart & checkout
	w1.findElement(By.xpath("//*[contains(@href,'#')]")).click();//main checkout
	w1.findElement(By.xpath("//*[@id='message']")).sendKeys("Happy Birthday baby");
	
	
	//w1.quit();
	*/
	
	
	}
	/*quit is for closing all from the new instances created
	close is going to close only one instance*/

}
