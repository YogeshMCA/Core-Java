package com.example.Exceptions;

import java.io.FileReader;

public class Exceptions {

	public static void main(String[] args) throws CheckedException{
		/*
		 * Checked Exceptions - Exceptions that are checked by the compiler. ( ClassNotFoundException, IOException, SQLException )
		 * When using FileReader without any exception handler, compiler will show an error. Eg: FileReader reader = new FileReader("hh.txt"); 
		 * This is because of public FileReader(java.lang.String arg0) throws java.io.FileNotFoundException;
		 * Throws - In method signature, this insist programmer to handle the exception.
		 * 
		 * Un-Checked Exceptions - Exceptions that can not be checked by the compiler and subclass of RuntimeException.(ArithmeticException, ArrayStoreException, ClassCastException)
		 */
		
	Transfer trans = new Transfer();	
		
	}

}

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