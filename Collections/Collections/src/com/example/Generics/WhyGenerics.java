package com.example.Generics;

import java.util.ArrayList;
import java.util.Collection;
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
		
		

		/*Array are Covariant type - an array of type T[] may contain elements of type T or any subtype of T.
		 * We can assign array of S to an array of T type, if S is a subtype of T.
		 * Because array knows its element type during runtime. 
		 * But we will get Disadvantage(Runtime Exception)
		 * 
		 * This we can capture it in compile time if we use collections
		 * 
		 * In Parameter:
		 * 	List<? super T> - It will only accept list of T and its Parent type
		 * 	List<? extends T> - It will only accept list of T and its sub types   
		 */
		
		Number[] nu = new Integer[2];
		nu[0]=10;
		//nu[1]=10.5; //Runtime Exception - ArrayStoreException - It will accept only Integer value
		
		
		Integer[] integer = new Integer[2];
		integer[0]=10;
		integer[1]=100;
		Number[] number = new Number[2];
		number[0]=10;
		number[1]=100;
		//integer=(Integer[]) number; //Runtime Exception - ClassCastException - Can not convert number to integer
		number = integer;
		number[0] = 32.0; //ArrayStoreException - It will accept only Integer value
		
		
		Person persons[] = new Person[2]; //Super class
		Partner partner1 = new Partner("YYY", "55"); //Sub class
		Partner partner2 = new Partner("XXX", "44");
		persons[0] = partner1;
		persons[1] = partner2;
		displayAll(persons);
		
		/*
		 * List are Non-Covariant type - Can not assign List<S> to List<T>, S is subclass of T. But can assign it with <? extends T> 
		 */
		List<Partner> partners = new ArrayList<>();
		partners.add(partner1);
		partners.add(partner2);
		
		List<Person> personsLst = new ArrayList<>();
		personsLst.add(new Person("Ra","44"));
		personsLst.add(new Person("Ram","34"));
		
		/*
		 * List<? extends T> - We can only "assign list of S", where S is sub type of T. But not add 
		 */
		List<? extends Person> personExt = new ArrayList<>();
		//personExt.add(new Partner("er","4"));
		personExt = partners;
		
		List<? super Person> personSuper = new ArrayList<>(); //same as  => List<Person> personSuper = new ArrayList<>();
		personSuper.add(new Partner("er","4"));
		personSuper.add(new Person("as","1"));
		/*
		 * List<? super T> - We can only "assign list of S", where S is super type of T.
		 * We can add T type into list, not parent type of T(S)
		 */
		List<? super Partner> partnerLst = new ArrayList<>();
		//partnerLst.add(new Person("as","1"));
		partnerLst.add(new Partner("as","1"));
		partnerLst = personsLst;
		
		
		List<?> sa = new ArrayList<>();
		sa.add(null); // Only accept null
		
		List<Object> obj = new ArrayList<>();
		obj.add("String");
		obj.add(1);

		System.out.println("Wildcard ??????????");
		objectType(obj); 
		wildCard(obj);
		
		List<String> qo = new ArrayList<>();
		qo.add("String");
		qo.add("XXX");
		wildCard(qo);
		//objectType(qo); Can not pass list of String to List of Object type
		
			
		System.out.println("Lower Bound");
		List<? super Integer> lo = new ArrayList<>();
		lo.add(new Integer(101));
		//lo.add(new Number(101));
		lowerBound(lo);
		
		List<Number> num = new ArrayList<>();
		num.add(105);
		num.add(10.5);
		lowerBound(num);
		
		List<Double> dou = new ArrayList<>();
		dou.add(105.5);
		//lowerBound(dou);
		
		upperBound(num);
		upperBound(dou);
		
		Intr inn = new Intr();
		List<Intr> classInn = new ArrayList<>();
		classInn.add(inn);
		lowerBoundInt(classInn);
		
		List<AA> subType = new ArrayList<>();
		subType.add(new AA());
		subType.add(new BB());
		lowerBoundWithClass(subType);
		for(AA aa : subType)
			System.out.println(aa);
		
		List<BB> subType1 = new ArrayList<>();
		subType1.add(new BB());
		//lowerBoundWithClass(subType1); Won't accept
		
		//Generic - limitation in method overloading
		overload(qo);
		
		//Raw type - Raw type can be assigned to generic type, to support native code
		List rawType = new ArrayList();
		rawType.add("RRR");
		rawType.add("RRR-XXX");
		rawType.add(1);
		List<String> gene = new ArrayList<>();
		gene=rawType;
		

		//Inheritance - Overriding is applicable for methods(Subclass method will be called), not for member variables(Super class variable will be used) 
		AA aa = new AA();
		BB bb = new BB();
		CC cc = new CC();
		aa = bb;
		System.out.println(aa.shr);
		aa.disp();
		
		
	}
	
	
	public static <T> void display(Collections<T> collections){
		System.out.println(collections.getValues(2));
	}
	
	public static void displayAll(Person[] persons){
		for(Person person:persons)
			System.out.println(person);
	}
	
	public static void wildCard(List<?> obj){
		System.out.println(obj);
	}
	
	public static void objectType(List<Object> obj){
		System.out.println(obj);
	}

	public static void lowerBound(List<? super Integer> obj){
		obj.add(10);
		//obj.add(10.5);
		System.out.println(obj);
	}
	
	// This method will accept List of parent types of BB(AA) and BB itself.
	public static void lowerBoundWithClass(List<? super AA> obj){
		//Obj - Can add all BB sub type
		obj.add(new BB());
		obj.add(new CC());
		//obj.add(new AA());
		//AA aa = (AA)obj.get(0);
		//System.out.println(aa.a);
		//System.out.println(obj.get(0).getClass());
	}
	
	public static void upperBound(List<? extends Number> obj){
		System.out.println(obj);
	}
	
	public static void lowerBoundInt(List<? super Intr> obj){
		C c = (C) obj.get(0);
		c.disp();
		System.out.println(obj.get(0).getClass());
	}
	
	//Erasure - Generics will be erased after the compilation List<String> to List. So Overloading is not possible with generics 
	public static void overload(List<String> str){
		for(String ss:str)
			System.out.println(ss);
	}
	
	/*public static void overload(List<Integer> str){
		for(Integer ss:str)
			System.out.println(ss);
	}*/
}


interface C{
	void disp();
}


class Intr implements C{

	@Override
	public void disp() {
		System.out.println("Class Intr======>");
		
	}
}
class AA{
	String a="AAAA";
	String shr = "SSSSSSSAAAAAA";
	void disp(){
		System.out.println("AA Prints");
	}
}
class BB extends AA{
	String b="BBBB";
	String shr = "SSSSSSSBBBBBB";
	void disp(){
		System.out.println("BB Prints");
	}
	void display(List<String> lst){
		System.out.println("List<String>");
	}
}

class CC extends BB{
	String c="CCCC";
	String shr = "SSSSSSSCCCCCC";
	void disp(){
		System.out.println("CC Prints");
	}
	/* Name clash compile time exception, in method overriding with generics  
	 * void display(List<Integer> lst){ 
		System.out.println("List<Integer>");
	}*/
}
	