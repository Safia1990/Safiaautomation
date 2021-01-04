package com.sessionone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Txtreader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
File obj=new File("C:\\Users\\safia.syed\\eclipse-workspace\\Seleniumlearning\\Filereader.txt");
BufferedReader b1=new BufferedReader(new FileReader(obj));
String Saf;
while((Saf=b1.readLine())!=null)
{
	System.out.println(Saf);
}

	}

}
