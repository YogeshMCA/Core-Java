package com.example.java8;

@FunctionalInterface
public interface LambdaInterface{
	void disp(String s);
	boolean equals(Object obj); //equals is a method of Object  type, so need to implement in sub class 
}