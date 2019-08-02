package com.example.Generics;

public class GenericSuperExtends {

	public static void main(String[] args) {
		
		F<ChildB> a1 = new F<>();
		a1.setT(new ChildB("BB Class"));
		getExtends(a1);
		// getSuper(a1); Not allowed
		
		F<ChildD> a2 = new F<>();
		a2.setT(new ChildD("DD Class"));
		getExtends(a2);
		getExtendsObj(a2);
		
		/*
		 * F<? extends ParentA> - We can not add anything to Object a3. But we can assign Object of it's sub type
		 */
		F<? extends ParentA> a3 = new F<>();
		a3 = a2;
		a3 = a1;
		
		/*
		 * CONSUMER - SUPER (Mainly used to add ParentA and its sub type objects. Not used in method parameter)
		 */
		F<? super ParentA> a4 = new F<>();
		a4.setT(new ChildB("BB Class"));
		a4.setT(new ChildD("DD Class"));
		getSuper(a4);
		
	}
	/* PRODUCER - EXTENDS (Mainly used in method Parameter)
	 * F<? extends ParentA> ex - It accepts only objects of ParentA class and its sub classes.
	 * F<ParentA> - Will only accept ParentA Object
	 * But we can not add ex.setT(new ChildB()) type.
	 */
	public static void getExtends(F<? extends ParentA> ex){
		System.out.println("GetExtends "+ex.getT().toString());
		
	}
	
	/*
	 * F<?> same====as F<? extends Object>. F<?> type can accept anything
	 */
	public static void getExtendsObj(F<? extends Object> ex){
		System.out.println("GetExtendsObj "+ex.getT().toString());
		
	}
	
	/* 
	 * F<? super ParentA> same===as F<Parent>. It only accept ParentA object.
	 */
	public static void getSuper(F<? super ParentA> ex){
		System.out.println("GetSuper "+ex.getT().toString());
		
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

class ParentA{
	String a;
	ParentA(String a){
		this.a = a;
	}
	public String toString(){
		return a;
	}
}

class ChildB extends ParentA{
	
	ChildB(String a){
		super("From B");
		this.a = a;
	}
}

class ChildD extends ParentA{
	ChildD(String a){
		super("From D");
		this.a = a;
	}
}

