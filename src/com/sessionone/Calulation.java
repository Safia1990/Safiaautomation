package com.sessionone;

import java.text.DecimalFormat;

public class Calulation {
	
	
	
	
	
	double subtotal(double Breakfasttotal ,double Lunchtotal)
	{
		
		double subtotal=Breakfasttotal+Lunchtotal;
		DecimalFormat df=new DecimalFormat(".00");
		System.out.println("Subtotal amount is " + df.format(subtotal));
		return subtotal;
		
		
	}
	
	double nontaxable(double bottlewater, double waterquantity) 
	{
		double nontaxable=bottlewater*waterquantity;
		DecimalFormat df=new DecimalFormat(".00");
		System.out.println("Non-taxable amount is" + df.format(nontaxable));
		return nontaxable;
	}
	
	double taxable(double subtotal,double nontaxable) {
		
		double taxable=subtotal-nontaxable;
		DecimalFormat df=new DecimalFormat(".00");
		System.out.println("Taxable amount is:" + df.format(taxable));
		return taxable;
	}
	
	double salestax(double taxable,String zipcode,double delfee)
	{
		if(zipcode.equals("77089"))
		{
			double s2=(delfee+taxable)*0.0825;
			
			System.out.println("sales tax is:" + s2);
			return s2;
		}
		
	
		else if(zipcode.equals("60606"))
		{
			double s3=(delfee+taxable)*	0.1175;
			DecimalFormat df=new DecimalFormat(".00");
			System.out.println("sales tax is:" + df.format(s3));
			return s3;
		}
		else
		{
			double s4=(delfee+taxable)*0.1025;
			DecimalFormat df=new DecimalFormat(".00");
			System.out.println("sales tax is:" + df.format(s4));
			return s4;
		}
	}
	double deliveryfee(double subtotal)
	{
		double deliveryfee=0;
		if(subtotal>100)
		{
			 deliveryfee= subtotal*0.1;
			 DecimalFormat df=new DecimalFormat(".00");
			 df.format(deliveryfee);
			 System.out.println("Deliver fee is : " + deliveryfee);
			
		}
		else if(subtotal<100)
		{
			 deliveryfee=10;
			
		}
		return deliveryfee;
	}	
	

	public double MainTotal(double salestax, double subtotal, double deliveryfee) {
		// TODO Auto-generated method stub
		double total1 ;
		
		   total1=salestax+subtotal+deliveryfee;
		   System.out.println("Total amount is:" + total1);
		   return total1;
		
	}
		
	}
	



