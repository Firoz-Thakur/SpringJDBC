package com.spring.jdbc.entity;

public class Student {

	private int id;
	private String name;
	private String city;

	
	public Student()
	{
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", city=" + city + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String city, String name) {
		super();
		this.id = id;
		this.city = city;
		this.name = name;
	}
	
}
