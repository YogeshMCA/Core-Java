package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		List<String> string = new ArrayList<>();
		string.add("Yogesh");
		string.add("Arun");
		string.add("Kamaraj");
		string.add("Mohan");
		string.add("amar");
		string.add("AAA");
		
		Stream<String> strm = string.stream();
		List<String> ss = strm.filter(element -> {logger("Filter");return element.startsWith("A");})
				 	.map(element->{logger("Map");return element.toUpperCase();}).collect(Collectors.toList());
		
		System.out.println(ss);
		
		/*
		 * Lazy Loading - the below stream get iterated only 2 times, because of findFirst() method("Arun" is present in second position which is the first name searching for) 
		 */
		Stream<String> strm1 = string.stream();
		strm1.filter(e -> {logger("Filter");return e.startsWith("A");}).findFirst();

	}
	public static void logger(String st){
		System.out.println(st);
	}

}
