package com.example.Generics;

import java.util.Arrays;

/*
 * Generics - Ensure Type safety to avoid runtime error...
 * Consider this is a Jar file and this class store array of same type. This jar file is given to client -WhyGeneric.java
 * 
 */

public class Collections<T> {
	T[] obj;
	private static int i=0;
	
	Collections(int size){
		obj = (T[])new Object[size];
		/*
		 * Array will know its type for allocating memory only during at run time.
		 * Type Erasure - Generic Type information are erased and not known at the runtime. new T[size] will not know what type 
		 * needs to be instantiated. To avoid this generic in List can be used. 
		 */
		//obj = new T[size]; 
	}
	
	public void add(T obj){
		this.obj[i++] = obj;
	}
	public T getValues(int i){
		return (T)this.obj[i];
	}
}

