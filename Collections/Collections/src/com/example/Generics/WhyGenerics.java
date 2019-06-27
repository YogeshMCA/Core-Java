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
		number[0] = 3.2; //ArrayStoreException
		
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
		
	}
	public static <T> void display(Collections<T> collections){
		System.out.println(collections.getValues(2));
	}
	
	public static void displayAll(Person[] persons){
		for(Person person:persons)
			System.out.println(person);
	}

}
