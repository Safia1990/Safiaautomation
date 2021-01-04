package com.sessionone;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Amazonfindelements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.navigate().to("https://www.amazon.in/");
		chrome.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone",Keys.ENTER);
		List<WebElement> Ame =chrome.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[4]/div[2]/div/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));
		for (WebElement w1 : Ame) {
			
			System.out.println(w1.getText());
			
		}
		//chrome.close();
		
		
	}

}

