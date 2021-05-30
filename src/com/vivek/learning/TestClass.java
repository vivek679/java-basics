package com.vivek.learning;

import java.util.HashMap;
import java.util.Map;

import com.vivek.learning.model.Employee;

public class TestClass
{

	public static void main(String[] args)
	{
		Employee e1 = new Employee(1,"Vivek");
		Employee e2 = new Employee(1,"Vivek");
		Employee e3 = new Employee(1,"kumar");
		Employee e4 = new Employee(2,"kumar");
		Employee e5 = new Employee(2,"Vivek");
		Employee e6 = new Employee(1,"kumar");
		System.out.println("Shallow compare " + (e1==e2));
		System.out.println("Deep compare " + (e1.equals(e2)));
		
		System.out.println("Shallow compare " + (e1==e3));
		System.out.println("Deep compare " + (e1.equals(e3)));
		
		System.out.println("----------------------");
		Map<Employee,Long> m = new HashMap<Employee,Long>() ;
		m.put(e1, 1l);
		m.put(e2, 2l);
		m.put(e3, 3l);
		m.put(e4, 4l);
		m.put(e5, 5l);
		m.put(e6, 6l);
		System.out.println("Size "+m.size());
		
		/**
		 *  so how elements are stored in map is as explained
		 *  	1st before putting in the hashMap() hashCode() method is invoked and then this value is stored in hash table  
		 *  	now while adding any other element if hashCode is same then equals method is invoked if equals then donot add otherwise add it
		 */
		
		for(Map.Entry<Employee,Long> e : m.entrySet())
		{
			System.out.println("Key : "+ e.getKey() + " ||  Value : "+ e.getValue());
		}
	}
	
}
