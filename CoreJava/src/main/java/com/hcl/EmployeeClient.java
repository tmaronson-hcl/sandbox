package com.hcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeClient {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("Joe", "Adams", "455-90-9090", "Engr", 12);
		Employee emp2 = new Employee("Martha", "Adams", "455-66-7654", "HR", 13);
		Employee emp3 = new Employee("Alice", "Adams", "432-66-8992", "IT", 22);
		Employee emp4 = new Employee("Alice", "Abrams", "432-66-8992", "IT", 22);
		
		List<Employee> emps = new ArrayList<>();
		emps.add(emp4);
		emps.add(emp3);
		emps.add(emp2);
		emps.add(emp1);
		Collections.sort(emps); // this line
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		

	}

}
