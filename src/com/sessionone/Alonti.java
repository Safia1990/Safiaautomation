package com.sessionone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alonti {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\safia.syed\\eclipse-workspace\\Seleniumlearning\\lib\\chromedriver.exe");
		WebDriver w1=new ChromeDriver();

		w1.navigate().to("https://orderdev.alonti.com/");
		w1.manage().window().maximize();
		w1.findElement(By.id("geoCode")).sendKeys("77089");//zipcode
		w1.findElement(By.xpath("//*[@id=\"modalDescription\"]/div/div/a")).click();//order now
		//w1.findElement(By.xpath("//html/body/div[2]/div/div/div/section/div/div/a")).click();
		Thread.sleep(4000);
	/*	w1.findElement(By.xpath("//*[@id=\"home_page\"]/section[2]/div/div/div[2]/div/div[2]/a")).click();//lunch
		w1.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div/a[5]")).click();//sub lunch box lunch
		Thread.sleep(3000);
		w1.findElement(By.xpath("//*[@id=\"lunch-box-lunches\"]/div[2]/div/div/div[6]/div[2]/a")).click();//traditional box lunch
		
		w1.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div[2]/div/div[2]/div/div[1]/div/div[1]/div[3]")).click();//quantity 2
		w1.findElement(By.xpath("//*[@id=\"add_cart\"]/div[2]/div/a[2]")).click();//add to cart
		//w1.findElement(By.xpath("//*[@id=\"add_cart\"]/div[1]/section/div[2]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div[4]/div[2]/div/div[1]/div[1]")).click();//reduce quantity
*/		
		w1.findElement(By.xpath("//div[@class=\"top-nav-bar\"]/div[4]/div/div/div/div[1]/div[6]/a[1]")).click();//login
		w1.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("safia.syed@softwaysolutions.com");//email
		w1.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("12345678");//password
		w1.findElement(By.xpath("//*[@id=\"sign_in\"]/div/div/div/div[1]/div/form[1]/div/button")).click();//login
		Thread.sleep(3000);
		w1.findElement(By.xpath("//*[@id=\"home_page\"]/section[1]/div[2]/div[2]/a[1]")).click();//Group order
		//Thread.sleep(5000);
		w1.findElement(By.xpath("//input[@id=\"groupName\" and@class=\"form-control\"]")).sendKeys("Selenium group");//Group name
		//String[] email= {"one@gmail.com,","two@gmail.com,","three@gmail.com,","four@gmail.com"};
	    WebElement emailfield=	w1.findElement(By.xpath("//*[@id=\"email\" or @type=\"email\"]"));
	  //  emailfield.sendKeys(email);//entering email address in one line
	    Thread.sleep(3000);
	   // w1.findElement(By.xpath("//*[@id=\"invite-people\"]/div/div/div/div/div/form/div/button")).click();
	    
	    
	    String emailenter[]=new String[4];
	    emailenter[0]="one@gmail.com";
	    emailenter[1]="two@gmail.com";
	    emailenter[2]="three@gmail.com";
	    emailenter[3]="four@gmail.com";
	    for(int i=0;i<emailenter.length;i++)
	    {
	    	emailfield.sendKeys(emailenter[i],Keys.ENTER);// entering email address using enter
	    }
	    
	    w1.findElement(By.xpath("//*[@id=\"invite-people\"]/div/div/div/div/div/form/div/button")).click();
	
	
		
		
		
		

}
}
