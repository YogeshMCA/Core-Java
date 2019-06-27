package com.example.Generics;

public class Person {
	
	private String name;
	private String age;
	
	Person(String name,String age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}
	
	public String toString(){
		return "Name:"+this.name +" Age:"+this.age;
	}

}
