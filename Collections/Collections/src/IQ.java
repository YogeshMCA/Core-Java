import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

public class IQ {

	public static void main(String[] args) {
		B b = new B("F");
		
		List<Integer> in = new ArrayList<>();
		in.add(10);
		in.add(0);
		in.add(15);
		in.add(10);
		in.add(9);
		in.add(15);
		System.out.println(in);
		getList(in);
		System.out.println(in);
		
		predicateFunction();

	}
	
	/*
	 * Input: 10 0 15 10 9 15 Output: 10 15 10 15
	 */
	public static void getList(List<Integer> list){
		int size = list.size();
		for(int i=1;i<(size-2);i++){
			if(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)){
				list.remove(i);
			}
		}
	}
	
	public static void predicateFunction(){
		List<String> string = new ArrayList<>();
		string.add("ABADA");
		string.add("BBAA");
		string.add("BBAA");
				
		System.out.println(string.stream().filter(filter("A")).map(mapper()).collect(Collectors.toList()));
		System.out.println(string.stream().filter(e -> Collections.frequency(string, e)>1).collect(Collectors.toSet()));
		
			
		List<Integer> integer = Arrays.asList(10,20,5,-3,45,1);
		System.out.println(integer.stream().sorted().limit(3).collect(Collectors.toList()));
		
	}
	
	public static Predicate<String> filter(String str){
		return (s) -> s.contains(str);
	}
	
	public static Function<String,Long> mapper(){
		return (s) -> s.chars().distinct().count();
	}

}

class A{
	/*static{
		System.out.println("RRRR");
	}*/
	/*A(){
		System.out.println("A Convv");
	}*/
	
	A(String a){
		System.out.println("A Con");
	}
	public void disp(List<String> lst){
		
	}
}

class B extends A{
	
	B(String a){
		//super();
		super(a);
		System.out.println("=====");
	}
	
}
