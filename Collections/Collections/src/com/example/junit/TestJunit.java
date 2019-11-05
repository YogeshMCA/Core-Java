package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit{
	
	@Before
	public void beforeTest(){
		System.out.println("Before Test");
	}
	
	@Test
	public void test(){
		System.out.println("Test");
		assertEquals("XXX", "XXX");
	}
	
	@After
	public void afterTest(){
		System.out.println("After Test");
	}
}
