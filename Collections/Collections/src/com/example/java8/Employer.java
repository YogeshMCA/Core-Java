package com.example.java8;

class Employer{
	String name;
	int Id;
	int age;
	
	Employer(int Id,String name,int age){
		this.Id = Id;
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return Id+" "+name+" "+age;
	}
}

