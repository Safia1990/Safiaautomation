package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");
WebDriver firefox=new FirefoxDriver();
firefox.navigate().to("https://orderdev.alonti.com/");//open application

firefox.manage().window().maximize();// maximize the window
firefox.findElement(By.xpath("//*[@id=\"geoCode\"]")).sendKeys("77004");//enter valid zipcode
firefox.findElement(By.xpath("//*[@class='btn orange  rounded-0 white']")).click();//click on start order
Thread.sleep(3000);
firefox.findElement(By.xpath("//*[contains(@href,'/tinga-chicken')]")).click();//click on warm up this winter
firefox.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div[2]/div/div[2]/div/div[1]/div/div[1]/div[3]")).click();//increase the quantity
firefox.findElement(By.xpath("/html/body/div[1]/div[1]/section/div[2]/div/div[2]/div/div[6]/div/div/div[1]/div/div/div[1]/div[2]/input")).sendKeys("4");//add quantity for soda
Thread.sleep(5000);
firefox.findElement(By.xpath("//*[@class='ti-new-tag-input ti-valid']")).sendKeys("Safia Syed");//Add who is this for?
firefox.findElement(By.xpath("//div[@class='notes-options']/div/div[2]/textarea")).sendKeys("Please don't add tomatoes");//Add special instructions
firefox.findElement(By.xpath("//div[@id=\"add_cart\"]/div[2]/div/a[2]")).click();//add to cart
Thread.sleep(3000);
firefox.findElement(By.xpath("//*[contains(@href,'https://orderdev.alonti.com/summary')]")).click();//checkout
firefox.findElement(By.xpath("//*[contains(@href,\"/warm-cookies\")]")).click();//click on save room for dessert
firefox.findElement(By.xpath("//*[contains(@href,\"chocolate-chunk\")]")).click();//select chocolate chunk
firefox.findElement(By.xpath("//input[@class=\"ti-new-tag-input ti-valid\"]")).sendKeys("Zunaira");//add who is this for?
firefox.findElement(By.xpath("//div[@id='add_cart']/div[2]/div[1]/a[2]")).click();// add to cart and checkout
//firefox.findElement(By.xpath("//*[contains(@href,'#')]")).click();



	}
	

}
