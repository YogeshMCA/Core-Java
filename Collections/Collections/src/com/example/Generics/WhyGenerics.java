package com.example.Generics;

import java.util.ArrayList;
import java.util.List;

/*
 * We have to ensure that the Collections class in the jar file only accept String.
 */
public class WhyGenerics {
	
	public static void main(String arg[]){
		/*
		 * Object[] Array will accept all types, but trying to use any function(like length() in String),
		   will get runtime error for Integer.
		   
		   Adding generic type <T>, will give compile time error when adding Integer to String T type. This will ensure type safety and avoid Runtime error.
		   Collections<String> collections = new Collections<String>(5);
		*/  
		Collections<String> collections = new Collections<String>(5);
		collections.add("A");
		//collections.add(12); 
		//display(collections);
		
		
		// Wildcard Example
		/*Array are Covariant type - an array of type T[] may contain elements of type T or any subtype of T.
		 * Also an array S[] is a subtype of the array T[] if S is a subtype of T. 
		 * Disadvantage(Runtime Exception) - Exception occur trying to add Float, even Float is subtype of Number here.   
		 */
		Integer[] integer = {10,20};
		Number[] number = integer;
		//number[0] = 32.0; //ArrayStoreException - It will accept only Integer value
		
		Partner partner1 = new Partner("YYY", "55");
		Partner partner2 = new Partner("XXX", "44");
		Person persons[] = new Person[2];
		persons[0] = partner1;
		persons[1] = partner2;
		displayAll(persons);
		
		/*
		 * List are Non-Covariant type - Can not assign List<S> to List<T>, S is subclass of T. But assign it with ? extends T 
		 */
		List<Partner> partners = new ArrayList<>();
		partners.add(partner1);
		partners.add(partner2);
		
		List<? extends Person> personLst = new ArrayList<>();
		personLst = partners; 
		
		List<Object> obj = new ArrayList<>();
		obj.add("String");
		obj.add(1);
		
		List<String> qo = new ArrayList<>();
		qo.add("String");
		qo.add("XXX");
		wildCard(qo);
		
			
		System.out.println("Lower Bound");
		List<? super Integer> lo = new ArrayList<>();
		lo.add(new Integer(101));
		//lo.add(new Number(101));
		
		List<Number> num = new ArrayList<>();
		num.add(105);
		num.add(10.5);
		
		List<Double> dou = new ArrayList<>();
		dou.add(105.5);
		
		lowerBound(lo);
		lowerBound(num);
		//lowerBound(dou);
		
		upperBound(num);
		upperBound(dou);
		
		Intr inn = new Intr();
		List<Intr> classInn = new ArrayList<>();
		classInn.add(inn);
		lowerBoundInt(classInn);
		
		//Generic - limitation in method overloading
		overload(qo);
		
		//Raw type - Raw type can be assigned to generic type, to support native code
		List rawType = new ArrayList();
		rawType.add("RRR");
		rawType.add("RRR-XXX");
		rawType.add(1);
		List<String> gene = new ArrayList<>();
		gene=rawType;
		
		
		
	}
	public static <T> void display(Collections<T> collections){
		System.out.println(collections.getValues(2));
	}
	
	public static void displayAll(Person[] persons){
		for(Person person:persons)
			System.out.println(person);
	}
	
	public static void wildCard(List<?> obj){
		System.out.println(obj);
	}

	public static void lowerBound(List<? super Integer> obj){
		System.out.println(obj);
	}
	
	public static void upperBound(List<? extends Number> obj){
		System.out.println(obj);
	}
	
	public static void lowerBoundInt(List<? super Intr> obj){
		C c = (C) obj.get(0);
		c.disp();
		System.out.println(obj.get(0).getClass());
	}
	
	//Erasure - Generics will be erased after the compilation List<String> to List. So Overloading is not possible with generics 
	public static void overload(List<String> str){
		for(String ss:str)
			System.out.println(ss);
	}
	
	/*public static void overload(List<Integer> str){
		for(Integer ss:str)
			System.out.println(ss);
	}*/
}


interface C{
	void disp();
}


class Intr implements C{

	@Override
	public void disp() {
		System.out.println("Class Intr======>");
		
	}
	
}