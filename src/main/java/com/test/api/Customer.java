package com.test.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Customer {

	private String name;
	
	private int age;
	
	private String city;
	
	private boolean isActive;
	
	private String DOB;
	
}
