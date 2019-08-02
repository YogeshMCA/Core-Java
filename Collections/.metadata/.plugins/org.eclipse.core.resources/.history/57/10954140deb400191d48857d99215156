package com.example.Generics;

public class GenericSuperExtends {

	public static void main(String[] args) {
		
		F<B> a1 = new F<>();
		a1.setT(new B("BB Class"));
		System.out.println(a1.getT().toString());
		
		

	}

}

class F<T>{
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class A{
	String a;
	A(String a){
		this.a = a;
	}
	public String toString(){
		return a;
	}
}

class B extends A{
	
	B(String a){
		super("From B");
		this.a = a;
	}
}

class D extends A{
	D(String a){
		super("From D");
		this.a = a;
	}
}

