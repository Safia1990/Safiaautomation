package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
/*Browser based-> chrome,IE related when we fill a form
	confirmation with yes/no- Alerts
desktop/system based-> Saving an excel/word file not found- This is OOS, thirdparty equaly. Patch work
4 methods can be handled for alerts-send, get,	*/	
		
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		chrome.navigate().to("https://orderdev.alonti.com/");
		chrome.manage().window().maximize();
		chrome.findElement(By.id("geoCode")).sendKeys("77089");//zipcode	
		
		chrome.findElement(By.xpath("//*[@id=\"modalDescription\"]/div/div/a")).click();
		Thread.sleep(4000);
		chrome.findElement(By.xpath("//div[@class=\"top-nav-bar\"]/div[4]/div/div/div/div[1]/div[6]/a[1]")).click();//login
		chrome.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("safia.syed@softwaysolutions.com");//email
		chrome.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("12345678");//password
		chrome.findElement(By.xpath("//*[@id=\"sign_in\"]/div/div/div/div[1]/div/form[1]/div/button")).click();//login
		Thread.sleep(5000);
		chrome.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[4]/div/div/div/div/div[7]/a[1]/span")).click();//click on name
		Thread.sleep(2000);
		chrome.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[4]/div/div/div/div/div[7]/div/a[2]")).click();//orders
		Thread.sleep(2000);
		chrome.findElement(By.xpath("//*[@id=\"__BVID__41\"]/tbody/tr[2]/td[9]/span[3]/a")).click();//reorder
		System.out.println(chrome.switchTo().alert().getText());
		chrome.switchTo().alert().dismiss();
		
		
	}

}
