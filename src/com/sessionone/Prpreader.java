package com.sessionone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class Prpreader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader F1=new FileReader("Propertyreader.properties");
		Properties P1=new Properties();
		P1.load(F1);
		System.out.println(P1.getProperty("Color"));
		
		

	}

}
