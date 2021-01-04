package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackDemo {
	
	
	public static final String USERNAME = "softwayqa3";
	  public static final String AUTOMATE_KEY = "rZ5FsAUDrQH8oCzEqTUr";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  public static void main(String[] args) throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "80");
	    
	    caps.setCapability("name", "softwayqa3's First Test");
	    
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.get("https://senecahue.softway.com");
	    Thread.sleep(5000);
	    driver.findElement(By.id("hs-login-widget-email")).sendKeys("zac.1mj11te032@gmail.com");
	    driver.findElement(By.id("hs-login-widget-password")).sendKeys("$Hysis@201#");
	    WebElement element = driver.findElement(By.xpath("//*[@id=\"hs-membership-form\"]/div[5]/div/input"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", element);
	    Thread.sleep(5000);
	    
	    
	  //  driver.findElement(By.xpath("//*[@id=\"hs-membership-form\"]/div[5]/div/input")).click();

	    //driver.quit();
	  }

}
