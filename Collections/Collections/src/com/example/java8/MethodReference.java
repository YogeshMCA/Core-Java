package com.example.java8;

public class MethodReference {

	public static void main(String[] args) {
		System.out.println(StaticClass.display());
		
		/*
		 * Used to refer static methods from a class. Argument for get method in functional Interface, should be same as in abs method.
		 */
		inter in = Math::abs;
		System.out.println(in.get(50));
		
		staticInterface sInter = StaticClass::display;
		System.out.println(sInter.get());
		
		/*
		 * Reference to a constructor - This will call the  WithoutImpl() constructor with argument
		 */
		Interface obj = WithoutImpl::new;
		obj.get("Reference to Constructor");
		
		/*
		 * Reference to instance method from instance
		 */
		
		WithoutImpl wuImpl = new WithoutImpl("Reference to instance method");
		Interface obj1 = wuImpl::print;
		obj1.get("===Reference to instance method===");
	}

}

class StaticClass{
	public static String display(){
		return "Method Reference";
	}
}

@FunctionalInterface
interface inter{
	
	public int get(int a);
}


@FunctionalInterface
interface staticInterface{
	public String get();
}

class WithoutImpl{
	String msg;
	WithoutImpl(String msg){
		this.msg = msg;
		System.out.println("Constructor Executing:"+msg);
	}
	void print(String msg){
		System.out.println(msg);
	}
}

@FunctionalInterface
interface Interface{
	public void get(String msg);
}

