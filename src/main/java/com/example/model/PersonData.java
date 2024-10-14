package com.example.model;

import java.util.List;

public class PersonData {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String company;
	private List<String> address;
	private List<String> paymentMethod;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<String> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(List<String> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	
}
