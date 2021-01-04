package com.sessionone;

import java.util.Scanner;

public class Arrayscanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String months[]=new String[12];
		months[0]="January";
		months[1]="Februaury";
		months[2]="March";
		months[3]="April";
		months[4]="May";
		months[5]="June";
		months[6]="July";
		months[7]="August";
		months[8]="September";
		months[9]="October";
		months[10]="November";
		months[11]="December";
		Scanner s1=new Scanner(System.in);
		int num;
		System.err.println("Enter month number");
		num=s1.nextInt();
		if(num<months.length)
		{
			System.out.println("Month for the number entered is "+ months[num]);
			
		}
		else
		{
			System.out.println("Please enter a valid number between o to 11 to display the month");
		}

	}
}



