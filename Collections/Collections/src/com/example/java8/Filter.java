package com.example.java8;

@FunctionalInterface
interface Filter<T>{
	boolean filter(T emp);
}