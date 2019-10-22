package com.example.java8;

import java.util.Iterator;
import java.util.List;

public class FilterList {
	public static <T> void filterObj(List<T> empl,Filter<T> filter) {
		Iterator<T> itr = empl.iterator();
		while(itr.hasNext()) {
			T obj = itr.next();
			if(!filter.filter(obj)){
				itr.remove();
			}	
		}
		
	}
}
