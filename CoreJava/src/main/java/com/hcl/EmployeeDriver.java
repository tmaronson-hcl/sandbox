package com.hcl.driver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.hcl.domain.Employee;

public class EmployeeDriver {

	public static void main(String[] args) {
		
		//List<Employee> lstEmps = new ArrayList<>();
		List<Employee> lstEmps = Arrays.asList(new Employee("Joseph", "Blow", 88),
				new Employee("Janet", "Window", 97),
				new Employee("Chris", "Kringle", 49),
				new Employee("Bob", "Bunny", 71),
				new Employee("Rachel", "Lang", 88),
				new Employee("Pamela", "Pinkster", 64 ),
				new Employee("Bill", "Mazeroski", 76));
		printDetails(lstEmps);
	}

	public static void printDetails(List<Employee> lstEmps) {

		for(Employee emp : lstEmps) {
			System.out.println(emp);  // call toString()
		}
		Collections.sort(lstEmps); // knows how to sort Employee(s) because we told it how to do this
		System.out.println(lstEmps);
	}

}
