package com.example.DesignPatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;


public class Singleton {

	public static void main(String[] args) throws Exception {
		Objects obj = Single.getInstance();
		Objects obj1 = Single.getInstance();
		System.out.println("Obj HashCode:"+obj.hashCode()+" Obj1 HashCode"+obj1.hashCode()+" ==:"+(obj1==obj)+"Equal:"+obj1.equals(obj));
		
		Constructor<?>[] con = Single.class.getDeclaredConstructors();
		con[0].setAccessible(true);
		Objects obj2 = (Single)con[0].newInstance();
		System.out.println(obj2.hashCode());
		
		Constructor<?>[] con1 = Single.class.getDeclaredConstructors();
		con1[0].setAccessible(true);
		Objects obj3 = (Single)con1[0].newInstance();
		System.out.println(obj3.hashCode());
	}

}

class Single implements Objects{
	private static Single sgObj=null;
	/*
	 * Reflection breaking the lazy loading design in singleton design pattern
	 * https://technonstop.com/java-singleton-reflection-and-lazy-initialization
	 */
	private Single()  {
		if(Single.sgObj!=null)
			throw new InstantiationError("Object already been created");
	}
	
	public static Single getInstance(){
		if(sgObj==null){
			sgObj = new Single();
			return sgObj;
		}
		return sgObj;
	}
	public static void display(){
		System.out.println("Singleton Class called");
	}
}

interface Objects{
	/*
	 * Can not override the static method, it should be defined in interface itself
	 */
	static void display() {
	}
}