package com.sessionone;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		WebDriver chrome=new ChromeDriver();
		
		chrome.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete11%2fweborders%2f");
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys("Tester");//user name
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_password']")).sendKeys("test");//password
		chrome.findElement(By.xpath("//*[@id='ctl00_MainContent_login_button']")).click();//login
		chrome.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a")).click();//view all orders
		
		//Below code helps to get the whole size of the table with  rows and columns count
		//*[@id="ctl00_MainContent_orderGrid"]/tbody/tr//this will fetch the whole table
		/*int rowcount=chrome.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr")).size();
		int colcount=chrome.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[1]/*")).size();
		System.out.println("Row count is " + rowcount);
		System.out.println("Column count is " + colcount);
		
		//fetching data from table
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=1;j<=colcount;j++)
			{
				System.out.print(chrome.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[" + i + "]/*[" + j + "]")).getText()+ " ");
			}
			System.out.println();
		}*/
		//*[contains(text(),'Steve Johns')]//preceding-sibling::td//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']--> direct method to check a box
		chrome.findElement(By.xpath("//*[contains(text(),'Charles Dodgeson')]//preceding-sibling::td//input[@type='checkbox']")).click();
		chrome.findElement(By.xpath("//*[contains(text(),'Mark Smith')]//preceding-sibling::td//input[@type='checkbox']")).click();
		chrome.findElement(By.xpath("//*[contains(text(),'Paul Brown')]//preceding-sibling::td//input[@type='checkbox']")).click();
		chrome.findElement(By.xpath("//*[contains(text(),'Susan McLaren')]//preceding-sibling::td//input[@type='checkbox']")).click();
		/*String AL="1715211";
		"//*[contains(text(),'"+ AL +""')]/tbody/tr/td[9]/span/a"
*/		
      // chrome.close();
        
        
		//Below code is getting1715211 things dynamically depending on users input  
		/* int x,y;
		 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the row");
	    x=sc.nextInt();
	    System.out.println("Enter the column");
		y=sc.nextInt();
		
		String w1=	"//*[@id='ctl00_MainContent_orderGrid']/tbody/tr["+x+"]/td["+y+"]";
		System.out.println(chrome.findElement(By.xpath(w1)).getText());*/
		
		
		//*[@id="ctl00_MainContent_orderGrid"]/tbody/tr[2]/td[2]
		//*[@id="ctl00_MainContent_orderGrid"]/tbody/tr[4]/td[2]
		
		
		
		
		
	}

}
