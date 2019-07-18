package com.example.Exceptions;

import java.sql.SQLException;

public class Exceptions {

	public static void main(String[] args) throws CheckedException{
		/*
		 * Checked Exceptions - Exceptions that are checked by the compiler. Can not Propagated by throw, but can do with throws ( ClassNotFoundException, IOException, SQLException )
		 * When using FileReader without any exception handler, compiler will show an error. 
		 * Eg: FileReader reader = new FileReader("hh.txt"); 
		 * This is because of public FileReader(java.lang.String arg0) throws java.io.FileNotFoundException;
		 * Eg: Class.forName("Hello"); ClassNotFouondException
		 * Throws - In method signature, this insist programmer to handle the exception.
		 * 
		 * Un-Checked Exceptions - Exceptions that can not be checked by the compiler and subclass of RuntimeException.(ArithmeticException, ArrayStoreException, ClassCastException)
		 * unchecked exceptions can be propagated
		 * 
		 * If the superclass method does not declare an exception, subclass overridden method cannot declare the "checked" exception but it can declare "unchecked" exception.
		 * 
		 * If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.
		 * 
		 * Can not use Try with Finally only when a method is declared with Checked exception
		 */
		
	Transfer trans = new Transfer();
	
	Child child = new Child();
	try{
		child.overrider();
	}catch(Exception e){
		System.out.println("Catch Block");
	}
	finally{
		System.out.println("Finally");
	}
	
	try{
		int a[] ={10};
		a[1]=20;
	}catch(ArrayIndexOutOfBoundsException | NullPointerException e){
		/*
		 * Multiple Exception in a catch block - Should not be Parent - Child class Eg: catch(Exception | NullPointerException e)
		 */
		System.out.println(e);
	}
	
		
	}

}

/*
 * User defined Checked Exception
 */
class CheckedException extends Exception{
	public CheckedException() {
		super();
	}
}

class Transfer{
	public Transfer()throws CheckedException {
		System.out.println("Transfer Class");
	}
}


/*
 * Overriding 
 */
class Parent{
	void overrider()throws Exception{
		System.out.println("Parent Class");
	}
}

class Child{
	void overrider()throws SQLException{
		System.out.println("Child Class");
	}
}