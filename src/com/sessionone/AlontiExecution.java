package com.sessionone;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlontiExecution {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		chrome.navigate().to("https://orderdev.alonti.com/");//url
		chrome.manage().window().maximize();
		chrome.findElement(By.id("geoCode")).sendKeys("77089");//zipcode
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);//use enter to reach home page
		r1.keyRelease(KeyEvent.VK_ENTER);	
		 WebDriverWait w1=new WebDriverWait(chrome, 10);//Explicit with a condition
			w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[1]/div/div[2]/a")));
			chrome.findElement(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[1]/div/div[2]/a")).click();//click on breakfast
			chrome.findElement(By.xpath("//*[contains(@href,'fiesta-breakfast')]")).click();//select fiesta breakfast
			
			WebElement b1=chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[1]/div/div[1]/div[2]/input"));
			 		 
						
			b1.clear();
			//chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5);
			b1.sendKeys("4");
			
			//chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[1]/div/div[1]/div[3]")).click();
			chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[2]/div/div[1]/div[1]")).click();
			WebElement dropdown= chrome.findElement(By.xpath("//*[@id=\"add-items\"]/div/div[1]/div/select"));// For drop downs we need to use webelements
			Select s1=new Select(dropdown);// create an object and pass the dropdowns location as a parameter
			s1.selectByIndex(1);
			WebElement element = chrome.findElement(By.xpath("//*[@id=\"add-items\"]/div/div[1]/div/div/div[1]/div[3]"));//increase quantity of coffee
			JavascriptExecutor executor = (JavascriptExecutor)chrome;
			executor.executeScript("arguments[0].click();", element);
            chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[4]/div/div[1]/div/div/div/ul/li/input")).sendKeys("Safia Syed", Keys.ENTER);//who is this for?
		    chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[4]/div/div[2]/textarea")).sendKeys("Please hold onto the lettuce");//special instructions
			chrome.findElement(By.xpath("//*[@id=\"add-items\"]/div/div[4]/div/div[1]/div[3]")).click();//add juice
			
			
			
			String[] A=chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[2]/div/p")).getText().split(":");
			System.out.println(A[1].trim().toString());

	chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[2]/div/a[2]")).click();//add to cart
	Thread.sleep(3000);
	
			System.out.println(chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[1]/div/div[3]/p")).getText());
	
				
			
			
			if(A[1].trim().toString().equals(chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[1]/div/div[3]/p")).getText().toString()))
			{
				System.out.println("order total from add to cart and summary page matches");
			}
			else {
				System.out.println("Something wrong totals dont match please check");
			}
		chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[1]/div/div[3]/div[2]/a")).click();//add warmcookies
		chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chrome.findElement(By.xpath("//*[@id=\"special-occasion-cookies-cookies\"]/div[2]/div/div/div[1]/div[2]/a")).click();//select an item
		chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		
		chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[3]/div/div[2]/textarea")).sendKeys("Happy Birthday Babes");// special instructions
		chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[2]/div/a[2]")).click();//add to cart & checkout
		chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[1]/div/div[2]/a[2]")).click();
		WebElement warmpopup=chrome.findElement(By.xpath("//*[@id=\"message\"]"));
		warmpopup.sendKeys("We love you the most always be happy");
		chrome.findElement(By.xpath("//*[@id=\"modal-checkout___BV_modal_body_\"]/div/div/a[1]")).click();
		chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chrome.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("safia.syed@softwaysolutions.com");
		chrome.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
		chrome.findElement(By.xpath("//*[@id=\"sign_in\"]/div/div/div/div[1]/div/form[1]/div/button")).click();
	    chrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println(chrome.switchTo().alert().getText());
		chrome.switchTo().alert().accept();
		
		
		//chrome.close();
	
	}

}
