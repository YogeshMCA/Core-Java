package com.example.java8;

class FilterObjName implements Filter<Employer>{

	@Override
	public boolean filter(Employer emp) {
		return emp.name.startsWith("K");
	}
	
}
