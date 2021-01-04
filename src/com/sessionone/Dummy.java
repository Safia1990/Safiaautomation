package com.sessionone;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Dummy {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		chrome.navigate().to("https://www.google.com/");
		//*[@id="gbwa"]/div/a
		/*chrome.navigate().to("https://orderdev.alonti.com/");
		chrome.manage().window().maximize();
		chrome.findElement(By.id("geoCode")).sendKeys("77089");//zipcode
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		chrome.close();*/
		Actions act=new Actions(chrome);
		WebElement w1= chrome.findElement(By.xpath("//*[@id=\"gbwa\"]/div/a"));
		//act.moveToElement(w1).build().perform();//mousehover
		act.moveToElement(w1).click().perform();//click with action class
		
		
		
		
		

	}

}
