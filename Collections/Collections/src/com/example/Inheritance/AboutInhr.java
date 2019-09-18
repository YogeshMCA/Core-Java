package com.example.Inheritance;

/*
 * The return type should be the same or a subtype of the return type declared in the original overridden method in the super class.
 * 
 * Interface - Can define default method implementation inside it. It can be called by its subclass object when it is not overridden.  
 */
public class AboutInhr{

	public static void main(String[] args) {
		 
		AboutInhr ai = new AboutInhr();
		ai.generic((s)->{s=s+"RR";System.out.print(s);});
		
		B b = new C();
		b.disp();

	}
	public void generic(Consume cc){
		cc.perform("Hello");
		cc.display();
	}
		
}

interface Consume{
	public void perform(String s);
	default void display(){
		System.out.println("Default Interface");
	}
}


abstract class A{
	public Number disp(){
		System.out.println("A");
		return 0;
	}
}

interface B{
	public default void disp(){
		System.out.println("B");
		
	}
}

class C implements B{
	public void disp1(){
		System.out.println("C");
		
	}
}
