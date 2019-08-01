package com.example.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*Why Lambda 
 * 	Enable to treat functionality as a method argument, or code as data.
	A function that can be created without belonging to any class.
	A lambda expression can be passed around as if it was an object and executed on demand.
	
	
 */

public class JavaFeatures {

	public static void main(String[] args) {
		Comparator<String> comparator = new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}
			
		
		};
		
		Comparator<String> compLam = (s1,s2)-> Integer.compare(s1.length(), s2.length());
		
		LambdaInterface lm = new LambdaInterface() {
			
			@Override
			public void disp(String s) {
				System.out.println("Inter class"+s);
				
			}
			
			
		};
		lm.disp("Printed");
		
		LambdaInterface lam = s->System.out.println(s);
		lam.disp("Hello");
				
		String str[] = {"Naveen","ArunKumar","Jaga"};
		Arrays.sort(str,compLam); //Sorting Algorithem - Quick Sort
		for(String s: str)
			System.out.println(s);
		
		List<String> lst = new LinkedList<String>();
		lst.add("AAA");
		lst.add("BBB");
		lst.add("DDD");
		lst.add("FFF");
		lst.sort(comparator);
		lst.forEach(s->System.out.print(s));
		

	
	}

}







