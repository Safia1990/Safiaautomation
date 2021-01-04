package com.sessionone;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Windowhandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		chrome.navigate().to("https://orderdev.alonti.com/");
		chrome.manage().window().maximize();
		chrome.findElement(By.id("geoCode")).sendKeys("77089");//zipcode
		chrome.findElement(By.xpath("//*[@id=\"modalDescription\"]/div/div/a")).click();
		Thread.sleep(3000);
		String s1=chrome.getWindowHandle();
		chrome.findElement(By.xpath("/html/body/footer/div/div/div/p/a")).click();
		Set<String> handles=chrome.getWindowHandles();
		for ( String objhandles : handles )//to iterate over list/set
		{
			chrome.switchTo().window(objhandles);
		}
		System.out.println(chrome.getWindowHandle());
		
		chrome.findElement(By.xpath("//*[@id=\"mega-menu-item-56\"]/a")).click();
		chrome.close();
		chrome.switchTo().window(s1);
		System.out.println(chrome.getCurrentUrl());
		//chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// - Implicit Wait
		/*WebDriverWait w1=new WebDriverWait(chrome, 20);//Explicit with a condition
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[5]/div/div[2]/a")));
		chrome.findElement(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[5]/div/div[2]/a")).click();
		*/
		
		//Wait w1=new FluentWait<WebDriver>(chrome).withTimeout(30,TimeUnit.SECONDS).pollingEvery(3,TimeUnit.SECONDS);
	/*	Wait wait = new FluentWait(chrome )
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class);

				WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
				public WebElement applyy(WebDriver driver) {
				return driver.findElement(By.id("foo"));
				}
				});*/
	chrome.close();
	}
	
	
	//

}
