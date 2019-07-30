package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class JavaFeatures {

	public static void main(String[] args) {
		Comparator<String> comparator = new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				return Integer.compare(arg0.length(), arg1.length());
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
		
		List<String> lst = new ArrayList<String>();
		lst.add("AAA");
		lst.add("BBB");
		lst.add("DDD");
		lst.add("FFF");
		
		lst.forEach(s->System.out.print(s));
	}

}
