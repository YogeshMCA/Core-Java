package com.example.java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*Why Lambda 
 * 	Enable to treat functionality as a method argument, or code as data.
	A function that can be created without belonging to any class.
	A lambda expression can be passed around as if it was an object and executed on demand.
	
	Basically "this" can't be used in static method or class. But can be used inside anonymous class.
	Also "this" can not be used in lambda, when lambda is inside any static method. But can use it if lambda is in non-static block
 */

public class Lambda {

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
		
		/*
		 * Creating user defined Comparator interface and Filter method to filter the list based on condition	
		 */
		System.out.println("Filter on User Defined Object");
		List<Employer> empl = new ArrayList<>();
		empl.add(new EmployerChild(1,"Yogesh",30));
		empl.add(new EmployerChild(2,"Ram",50));
		empl.add(new EmployerChild(3,"Kumar",25));
		empl.add(new EmployerChild(4,"Kannan",28));
		
		FilterList.filterObj(empl,new FilterObjName());
		
		for(Employer e: empl)
			System.out.println(e);
		
		System.out.println("Filter on String");
		List<String> string = new ArrayList<>();
		string.add("Yogesh");
		string.add("Arun");
		string.add("Kamaraj");
		string.add("Mohan");
		string.add("amar");
		/*
		 * Lambda - It is an implementation of method in interface.
		 */
		//FilterList.filterObj(string,(s)->s.startsWith("Y"));
		//FilterList.filterObj(string,new FilterStringName());
		//FilterList.filterObj(string,(s)->{System.out.println(s);return s.startsWith("Y");});
		//FilterList.filterObj(string,s->methodRef(s));
		FilterList.filterObj(string,Lambda::methodRef);
		
		for(String e: string)
			System.out.println(e);
		
		
	}		
	public static boolean methodRef(String s){
		return s.startsWith("Y");
	}
	
}



