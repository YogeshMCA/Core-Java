package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		List<String> string = new ArrayList<>();
		for(int i=1;i<=100;i++){
			string.add("Yogesh");
			string.add("Arun");
			string.add("Kamaraj");
			string.add("Mohan");
			string.add("amar");
			string.add("Amar");
		}
		
		Stream<String> strm = string.stream();
		List<String> ss = strm.filter(element -> {logger("Filter");return element.startsWith("A");})
				 	.map(element->{logger("Map");return element.toUpperCase();}).collect(Collectors.toList());
		
		System.out.println(ss);
		
		/*
		 * Lazy Loading - the below stream get iterated only 2 times, because of findFirst() method("Arun" is present in second position which is the first name searching for) 
		 */
		Stream<String> strm1 = string.stream();
		strm1.filter(e -> {logger("Filter");return e.startsWith("A");}).findFirst();
		
		/*
		 *  Predicate is a functional interface and can be used as the assignment target for a lambda expression or method reference.
		 *  Can use predicates anywhere where you need to evaluate a condition on group/collection of similar objects such that evaluation can result either in true or false.
		 * Creating user defined Predicate class (i.e) Implement user defined filter
		 * 
		 */
		System.out.println("======");
		Stream<String> strm2 = string.stream();
		Predict p = new Predict();
		//String name = strm2.filter(p).findAny().orElse("Name not in");
		//String name = strm2.filter(s->s.startsWith("B")).findAny().orElse("Name not in");
		List<String> name = strm2.filter(p).map(e->e.toString()).collect(Collectors.toList());
		System.out.println("==="+name);
		
		
		/*
		 * Parallel Stream
		 */
		long start,end;
		Stream<String> strm3 = string.stream();
		start = System.currentTimeMillis();
		long count = strm3.filter(s->s.endsWith("A")).count();
		end = System.currentTimeMillis();
		System.out.println("Time taken:"+(end-start) +"Result "+count);
		
		Stream<String> strm4 = string.parallelStream();
		start = System.currentTimeMillis();
		long count1 = strm4.filter(t->t.endsWith("A")).count();
		end = System.currentTimeMillis();
		System.out.println("Time taken:"+(end-start) +"Result "+count1);
		
		
		
	}
	public static void logger(String st){
		System.out.println(st);
	}

}

class Predict implements Predicate<String>{

	@Override
	public boolean test(String t) {
			System.out.println("Test");
			return (t.startsWith("a") || (t.startsWith("A")));
	}
	
}