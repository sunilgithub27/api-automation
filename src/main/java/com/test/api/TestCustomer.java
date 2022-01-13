package com.test.api;

public class TestCustomer {

	public static void main(String[] args) {
		

		Customer C= new Customer("Sunil", 28, "Bangalore",true, "27-09-1983");
		System.out.println(C);
		
	Customer c2=	Customer.builder().age(34).city("GJK").build();
	System.out.println(c2);
	System.out.println(c2.getAge());
	}

}
