package com.example.Generics;
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
		display(collections);
				
	}
	public static <T> void display(Collections<T> collections){
		System.out.println(collections.getValues(2));
	}

}
