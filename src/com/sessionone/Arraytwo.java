package com.sessionone;

public class Arraytwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int monthdays[]=new int[12];
monthdays[0]=31;
monthdays[1]=29;
monthdays[2]=31;
monthdays[3]=30;
monthdays[4]=31;
monthdays[5]=30;
monthdays[6]=31;
monthdays[7]=31;
monthdays[8]=30;
monthdays[9]=31;
monthdays[10]=30;
monthdays[11]=31;

System.out.println("Month is"+ monthdays[4]);
for(int i=0;i<monthdays.length;i++)
{
	System.out.println(monthdays[i]);
}
	}

}
