package java_tutorials;

import java.util.Scanner;

public class var_datatypes {

	public static void main(String[] args) {
		
		int n =10;  //n is variable  , int float string all are data types 
		int m =20;
		String s= "kumar";
		Float f=3.5f;
		
		System.out.println("all variables are "+n +"\n"+m+"\n"+s+"\n"+f);
		
		//we can do all arthematic , logical operattions 
		//----------------------------------------------------------------------------------------------------
		int x;
		String y;
		float z;
		char c;
		
		Scanner obj = new Scanner(System.in);
		
		System.out.println("enter a number  : ");
		x=obj.nextInt();
		System.out.println("entered number is : "+x);
		
		
		System.out.println("enter a word  : ");
		
		obj.nextLine();   // clear buffer
		y = obj.nextLine();
		System.out.println("entered word is : "+y);
		
		
		System.out.println("enter a  decimal number  : ");
		z=obj.nextFloat();
		System.out.println("entered number is : "+z);
		
		System.out.println("enter a character  : ");
		c=obj.next().charAt(0);
		System.out.println("entered char  is : "+c);
		
		
		
		
		
		

	}

}
