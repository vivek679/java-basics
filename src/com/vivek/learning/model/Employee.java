package com.vivek.learning.model;

public class Employee
{
	private int id;
	private String name;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public boolean equals(Object o)
	{
		System.out.println("equals invoked...");
		if(o == null || getClass() != o.getClass())
			return false;
		if(o == this)
			return true ;
		
		Employee e = (Employee) o;
//			return (e.id == this.id && e.name == this.getName());
			return (e.id == this.id);
		
	}
	
	public int hashCode()
	{
		System.out.println("hashMap invoked...");
		return this.getId() + this.name.hashCode();
	}
}
