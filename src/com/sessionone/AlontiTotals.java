package com.sessionone;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Arrays;
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

public class AlontiTotals {
	static WebDriver chrome;

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		chrome = new ChromeDriver();
		chrome.navigate().to("https://orderdev.alonti.com/");// url
		chrome.manage().window().maximize();
		String zipcode = "77089";
		chrome.findElement(By.id("geoCode")).sendKeys(zipcode);// zipcode

		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);// use enter to reach home page
		r1.keyRelease(KeyEvent.VK_ENTER);
		WebDriverWait w1 = new WebDriverWait(chrome, 10);// Explicit with a condition
		w1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[1]/div/div[2]/a")));
		chrome.findElement(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[1]/div/div[2]/a")).click();// click
																												// on
																												// breakfast
		chrome.findElement(By.xpath("//*[contains(@href,'fiesta-breakfast')]")).click();// select fiesta breakfast

		WebElement b1 = chrome.findElement(
				By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[1]/div/div[1]/div[2]/input"));

		Thread.sleep(3000);
		b1.sendKeys(Keys.CONTROL + "a");
		b1.sendKeys(Keys.DELETE);

		Thread.sleep(5000);
		b1.sendKeys("4");
		Thread.sleep(3000);
		chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[2]/div/div[1]/div[1]"))
				.click();
		WebElement dropdown = chrome.findElement(By.xpath("//*[@id=\"add-items\"]/div/div[1]/div/select"));// For drop
																											// downs we
																											// need to
																											// use
																											// webelements
		Select s1 = new Select(dropdown);// create an object and pass the dropdowns location as a parameter
		s1.selectByIndex(0);
		WebElement element = chrome.findElement(By.xpath("//*[@id=\"add-items\"]/div/div[1]/div/div/div[1]/div[3]"));// increase
																														// quantity
																														// of
																														// coffee
		JavascriptExecutor executor = (JavascriptExecutor) chrome;
		executor.executeScript("arguments[0].click();", element);
		chrome.findElement(By.xpath(
				"//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[4]/div/div[1]/div/div/div/ul/li/input"))
				.sendKeys("Safia Syed", Keys.ENTER);// who is this for?
		chrome.findElement(
				By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[4]/div/div[2]/textarea"))
				.sendKeys("Please hold onto the lettuce");// special instructions
		chrome.findElement(By.xpath("//*[@id=\"add-items\"]/div/div[4]/div/div[1]/div[3]")).click();// add juice
		chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[2]/div/a[2]")).click();// add to cart
		Thread.sleep(3000);

		System.out.println(Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/div/h3"))
				.getText()));// Product price
		System.out.println(Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[1]"))
				.getText()));// Choose Fruit or Yogurt Bar
		System.out.println(Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[2]"))
				.getText()));// Value-added coffee service amount
		System.out.println(Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[3]"))
				.getText()));// Value-added assorted individual juices amount
		System.out.println(Splitext1(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[2]"))
				.getText()));// Value-added coffee service quantity
		System.out.println(Splitext1(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[3]"))
				.getText()));// Value-added assorted individual juices quantity

		System.out.println(Splitext2(
				chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[3]/p"))
						.getText()));// Final total

		double d1 = Store();
		double d2 = Total();
		if (d1 == d2) {
			System.out.println("Indiviual total and product total both the values match");
		} else {
			System.out.println("Values dont match");
		}

		// chrome.close();

		chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[1]/div/div[2]/a[1]")).click();// Add
																													// more
		chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chrome.findElement(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[2]/div/div[2]/a")).click();// Add
																												// lunch
		chrome.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div/a[6]")).click();// hotplates
		Thread.sleep(3000);
		chrome.findElement(By.xpath("//*[@id=\"hot-plates-sides-italian-flavors\"]/div/div/div[1]/div[2]/a")).click();// Mr.Beefs
		// Lasagna

		WebElement element1 = chrome.findElement(
				By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div/div/div[2]/div/div[2]/div/div[6]/div[1]/img"));
		JavascriptExecutor executor1 = (JavascriptExecutor) chrome;
		executor1.executeScript("arguments[0].click();", element1);// Chicken cranberry kale salad bowl

		chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[2]/div/a[2]")).click();// Add to cart and checkout

		chrome.findElement(
				By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/a"))
				.click();// edit the product
		WebElement element2 = chrome.findElement(By.xpath("//*[@id=\"add-items\"]/div/div[3]/div/div[1]/div[3]"));
		JavascriptExecutor executor2 = (JavascriptExecutor) chrome;
		executor.executeScript("arguments[0].click();", element2);// bottled water
		chrome.findElement(By.xpath("//*[@id=\"add_cart\"]/div[2]/div/a")).click();// add to cart

		System.out.println(Splitext(chrome
				.findElement(By.xpath(
						"//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[2]/div/div/div/h3"))
				.getText()));// Mrs. P's Beef Lasagna
		System.out.println(Splitext(chrome
				.findElement(By
						.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[2]/div/div/p[1]"))
				.getText()));// Side Salad: Cobb salad bowl
		System.out.println(Splitext(chrome
				.findElement(By
						.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[2]/div/div/p[2]"))
				.getText()));// bottle water amount
		
		double bottlewater=Double.parseDouble(Splitext(chrome
				.findElement(By
						.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[2]/div/div/p[2]"))
				.getText()));
		System.out.println(Splitext1(chrome
				.findElement(By
						.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[2]/div/div/p[2]"))
				.getText()));// bottle water quantity
		int waterquantity=Integer.parseInt(Splitext1(chrome
				.findElement(By
						.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[2]/div/div/p[2]"))
				.getText().replaceAll("\\s", "")));
		
		System.out.println(Splitext2(chrome
				.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div[2]/div/div[3]/p"))
				.getText()));// final total
		System.out.println(Splitext2(chrome.findElement(By.xpath("//*[@id=\"sub-total\"]")).getText()));// subtotal
		double subtotal=Double.parseDouble(Splitext2(chrome.findElement(By.xpath("//*[@id=\"sub-total\"]")).getText()));
		
		System.out.println(Splitext(chrome.findElement(By.xpath("//*[@id=\"taxable\"]")).getText()));// taxable amount
		double taxamount=Double.parseDouble(Splitext(chrome.findElement(By.xpath("//*[@id=\"taxable\"]")).getText()));
		
		System.out.println(Splitext(chrome.findElement(By.xpath("//*[@id=\"non-tax\"]")).getText()));// non-taxable
		double nontax=Double.parseDouble(Splitext(chrome.findElement(By.xpath("//*[@id=\"non-tax\"]")).getText()));
		
	
		
		System.out.println(Splitext2(chrome.findElement(By.xpath("//*[@id=\"sales-tax\"]")).getText()));// sales tax
		double salestax= Double.parseDouble(Splitext2(chrome.findElement(By.xpath("//*[@id=\"sales-tax\"]")).getText()));
		
		System.out.println(Splitext2(chrome.findElement(By.xpath("//*[@id=\"main-total\"]")).getText()));// Total
		double Total=Double.parseDouble(Splitext2(chrome.findElement(By.xpath("//*[@id=\"main-total\"]")).getText()));
		
		System.out.println(chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[1]/div/div[1]/div[3]/p")).getText());
		
	
		
		
		  if(zipcode.equals("77089")) {
			  
		  
			   double salestaxvalue=0.0825; 
			   double cal=bottlewater*waterquantity,deliverfee,salestaxamount,taxable,totalamount;
			   String S=Double. toString(cal);
			   
	
			  
			   if(chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[1]/div/div[1]/div[3]/p")).getText().contains(S))
			   {
				   System.out.println("Water in non-taxable");
				   
				   if(subtotal>100)
				   {
					   deliverfee=subtotal*0.1;
					//   deliverfee=Math.round(deliverfee);
					   System.out.println("Delivery fee is:" + deliverfee);
					   
					   taxable=subtotal-cal;
					 //  taxable=Math.round(taxable);
					   System.out.println("Taxable amount is:" + taxable);
					   
					   salestaxamount=(deliverfee+taxable)*salestaxvalue;
					  // salestaxamount=Math.round(salestaxamount);
					   System.out.println("Sales tax amount is:"+ salestaxamount);
					   
					  
					   
					   totalamount=subtotal+deliverfee+salestaxamount;
					   DecimalFormat df=new DecimalFormat(".00")	;				
					   //  totalamount=Math.round(totalamount);
					   
					   System.out.println("The total summary value is :"+df.format(totalamount) );
					  
					   
				   }
				   
			   }
		  
		  
		  
		  }
	}

	static String Splitext(String t1) {

		return t1.split("\\$")[1].split("\\)")[0];
	}

	static String Splitext1(String t2) {
		return t2.split("X")[1];
	}

	static String Splitext2(String t3) {
		return t3.split("\\$")[1];
	}

	static double Store() {
		String s1 = Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/div/h3"))
				.getText());
		String s2 = Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[1]"))
				.getText());
		String s3 = Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[2]"))
				.getText());
		String s4 = Splitext(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[3]"))
				.getText());
		String s5 = Splitext1(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[2]"))
				.getText());
		String s6 = Splitext1(chrome
				.findElement(
						By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[2]/div/div/p[3]"))
				.getText());

		double Productprice = Double.parseDouble(s1);
		double Sideprice = Double.parseDouble(s2);
		double addoncoffee = Double.parseDouble(s3);
		double addonjuice = Double.parseDouble(s4);
		double addoncoffqu = Double.parseDouble(s5);
		double addonjuiqu = Double.parseDouble(s6);
		return (Productprice * 4) + (Sideprice) + (addoncoffee * addoncoffqu) + (addonjuice * addonjuiqu);

	}

	static double Total() {
		String s7 = Splitext2(
				chrome.findElement(By.xpath("//*[@id=\"order_summary\"]/section/div/div/div[2]/div/div/div/div[3]/p"))
						.getText());
		double total = Double.parseDouble(s7);

		return total;
	}
}
