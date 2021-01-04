package com.sessionone;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Properties;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng

{

	// TODO Auto-generated method stub
	// go through features of testing
	// go through - LIST and MAP, we need to add library
	WebDriver chrome;
	Properties P1;
	Properties P2;

	@BeforeTest
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		chrome = new ChromeDriver();
		FileReader F1 = new FileReader("Propertyreader.properties");
		P1 = new Properties();
		P1.load(F1);
		FileReader data=new FileReader("Datastored.properties");
		P2=new Properties();
		P2.load(data);
	

	}

	@Test(priority = 1)
	public void start() {
		chrome.navigate().to(P1.getProperty("Alonti-dev-URL"));
	}

	@Test(priority = 3)
	public void title() {
		System.out.println(" The page title is :" + chrome.getTitle());
		String S1 = chrome.getTitle();
		String S2 = "Alonti";
		assertEquals(S1, S2);

	}

	@Test(priority = 2)
	public void zipcode() throws AWTException {
		String Z1 = P2.getProperty("Zipcode-num");

		chrome.findElement(By.id(P1.getProperty("Zipcode"))).sendKeys(Z1);

		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);// use enter to reach home page
		r1.keyRelease(KeyEvent.VK_ENTER);
		chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Z2 = chrome.findElement(By.xpath(P1.getProperty("Zipcodehomepageheader"))).getText();
		assertEquals(Z1, Z2);

	}

	@Test(priority = 4)
	public void selectbreakfast() throws InterruptedException {
		chrome.findElement(By.xpath(P1.getProperty("Breakfast"))).click();
		Thread.sleep(3000);
		chrome.findElement(By.xpath(P1.getProperty("Fiesta-Breakfast-Taco-Package"))).click();

	}

	@Test(priority = 5)
	public void addtocart() throws InterruptedException {
		WebElement b1 = chrome.findElement(By.xpath(P1.getProperty("Fiesta-Breakfast-Taco-Package-Qantity")));

		b1.sendKeys(Keys.CONTROL + "a");
		b1.sendKeys(Keys.DELETE);
		chrome.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		b1.sendKeys("4");

		chrome.findElement(By.xpath(P1.getProperty("Side-Premium-sliced-fruit-tray"))).click();
		WebElement dropdown = chrome.findElement(By.xpath(P1.getProperty("Value-added-decafinatted-coffee")));

		Select s1 = new Select(dropdown);
		s1.selectByIndex(1);
		WebElement element = chrome.findElement(By.xpath(P1.getProperty("Value-added-decafinatted-coffee-Quantity")));
		JavascriptExecutor executor = (JavascriptExecutor) chrome;
		executor.executeScript("arguments[0].click();", element);
		chrome.findElement(By.xpath(P1.getProperty("Who-is-this-for?"))).sendKeys(P2.getProperty("Name"), Keys.ENTER);
		chrome.findElement(By.xpath(P1.getProperty("Special-Instructions"))).sendKeys(P2.getProperty("Instructions"));

		WebElement element1 = chrome.findElement(By.xpath(P1.getProperty("Value-added-assorted-individual-juices")));
		JavascriptExecutor executor1 = (JavascriptExecutor) chrome;
		executor.executeScript("arguments[0].click();", element1);
		String T1 = Splitext2(chrome.findElement(By.xpath(P1.getProperty("Breakfast-Item-total"))).getText());
		chrome.findElement(By.xpath(P1.getProperty("Breakfast-Add-To-Cart-&-Checkout"))).click();
		Thread.sleep(5000);
		String T2 = Splitext2(
				chrome.findElement(By.xpath(P1.getProperty("Fiesta-Breakfast-Taco-Package-Subtotal"))).getText());
		assertEquals(T1, T2);

	}

	@Test(priority = 6)
	public void addmore() {
		WebElement element1 = chrome.findElement(By.xpath(P1.getProperty("Add-more")));
		JavascriptExecutor executor1 = (JavascriptExecutor) chrome;
		executor1.executeScript("arguments[0].click();", element1);

	}

	@Test(priority = 7)
	public void addlunch() throws InterruptedException {
		chrome.findElement(By.xpath(P1.getProperty("Lunch"))).click();
		chrome.findElement(By.xpath(P1.getProperty("Hot-Plates-&-Sides"))).click();
		WebElement element1 = chrome.findElement(By.xpath(P1.getProperty("Mrs.P's-Beef-Lasagna")));
		JavascriptExecutor executor1 = (JavascriptExecutor) chrome;
		executor1.executeScript("arguments[0].click();", element1);

	}

	@Test(priority = 8)
	public void addtocartlunch() {
		WebElement element1 = chrome.findElement(By.xpath(P1.getProperty("Side-Chicken-cranberry-kale-salad-bowl")));
		JavascriptExecutor executor1 = (JavascriptExecutor) chrome;
		executor1.executeScript("arguments[0].click();", element1);

		chrome.findElement(By.xpath(P1.getProperty("Lunch-Add-To-Cart-&-Checkout"))).click();
	}

	@Test(priority = 9)
	public void editlunch() {
		chrome.findElement(By.xpath(P1.getProperty("Beef-Lasagna-Edit-Full-details"))).click();
		WebElement element2 = chrome.findElement(By.xpath(P1.getProperty("Bottled-Water")));
		JavascriptExecutor executor2 = (JavascriptExecutor) chrome;
		executor2.executeScript("arguments[0].click();", element2);
		chrome.findElement(By.xpath(P1.getProperty("Beefs-Update-Cart-Item"))).click();
	}

	@Test(priority = 10)
	public void getvalues() {
		double bottlewater = Double
				.parseDouble(Splitext(chrome.findElement(By.xpath(P1.getProperty("Bottle-water-price"))).getText()));
		int waterquantity = Integer.parseInt(Splitext1(
				chrome.findElement(By.xpath(P1.getProperty("Bottle-water-Quantity"))).getText().replaceAll("\\s", "")));

		double subtotal = Double
				.parseDouble(Splitext2(chrome.findElement(By.xpath(P1.getProperty("Subtotal"))).getText()));

		double taxamount = Double
				.parseDouble(Splitext(chrome.findElement(By.xpath(P1.getProperty("Taxable"))).getText()));

		double nontaxable = Double
				.parseDouble(Splitext(chrome.findElement(By.xpath(P1.getProperty("Non-taxable"))).getText()));

		double salestax = Double
				.parseDouble(Splitext2(chrome.findElement(By.xpath(P1.getProperty("Sales-tax"))).getText()));
		double deliveryfee = Double
				.parseDouble(Splitext2(chrome.findElement(By.xpath(P1.getProperty("Delivery-fee"))).getText()));

		double MainTotal = Double
				.parseDouble(Splitext2(chrome.findElement(By.xpath(P1.getProperty("Total"))).getText()));

		double Breakfasttotal = Double.parseDouble(Splitext(
				chrome.findElement(By.xpath(P1.getProperty("Fiesta-Breakfast-Taco-Package-Maintotal"))).getText()));

		double Lunchtotal = Double.parseDouble(
				Splitext2(chrome.findElement(By.xpath(P1.getProperty("Mrs-P's-Beef-Lasagna-Maintotal"))).getText()));

		String zipcode = chrome.findElement(By.xpath(P1.getProperty("Zipcodehomepageheader"))).getText();
		if (zipcode.equals("77089")) {
			Calulation c1 = new Calulation();
			double grandsub = c1.subtotal(Breakfasttotal, Lunchtotal);

			if (grandsub == subtotal) {
				System.out.println("Subtotal is correct");

			} else {
				System.out.println("Subtotal doesn't match");
			}
			double nontaxable1 = c1.nontaxable(bottlewater, waterquantity);
			if (nontaxable1 == nontaxable) {
				System.out.println("nontaxable amount is correct");
			} else {
				System.out.println("nontaxable amount is incorrect");
			}

			double salestax1 = c1.salestax(taxamount, zipcode, deliveryfee);
			DecimalFormat df = new DecimalFormat(".00");

			if (Double.parseDouble(df.format(salestax1)) == salestax) {

				System.out.println("Salex tax is correct");
			} else {
				System.out.println("Sales tax is incorrect");
			}
			double del = c1.deliveryfee(subtotal);
			DecimalFormat dt = new DecimalFormat(".00");
			if (Double.parseDouble(dt.format(del)) == deliveryfee) {
				System.out.println("Delivery fee is correct");
			} else {
				System.out.println("Delivery fee doesn't match");
			}
			double taxable = c1.taxable(subtotal, nontaxable);
			if (taxable == taxamount) {
				System.out.println("Taxable amount is correct");
			} else {
				System.out.println("Taxable amount is incorrect");
			}
			double tot = c1.MainTotal(salestax, subtotal, deliveryfee);
			if (tot == MainTotal) {
				System.out.println("Total is correct");
			} else {
				System.out.println("Total doesn't match");
			}

		}
		
	}
	@Test(priority=11)
	public void checkout()
	{
		chrome.findElement(By.xpath(P1.getProperty("Checkout"))).click();
		
		
	}
	@Test(priority=12)
	public void login() throws InterruptedException
	{
		/*WebDriverWait wait = new WebDriverWait(chrome,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();*/
		chrome.findElement(By.xpath(P1.getProperty("Username"))).sendKeys(P2.getProperty("email-id"));
		chrome.findElement(By.xpath(P1.getProperty("Password"))).sendKeys(P2.getProperty("psswrd"));
		chrome.findElement(By.xpath(P1.getProperty("Sign-in"))).click();
		Thread.sleep(5000);
		
			System.out.println(chrome.switchTo().alert().getText());
			chrome.switchTo().alert().accept();
	}
	@Test(priority=13)
	public void deliverypage()
	{
		
	}

	static String Splitext2(String t1) {

		return t1.split("\\$")[1];
	}

	static String Splitext(String t1) {

		return t1.split("\\$")[1].split("\\)")[0];
	}

	static String Splitext1(String t2) {
		return t2.split("X")[1];
	}

}

/*
 * @AfterTest public void task() { chrome.close(); }
 */
