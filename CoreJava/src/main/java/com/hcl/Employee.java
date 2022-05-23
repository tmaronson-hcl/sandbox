package com.hcl;

/* So what is at least kind of important after we went through this demo?
 * 1. Review of some basic concepts like constructors, class structure and
 * some of the methods associated with classes (toString(), equals and hashcode
 * later, getters).
 * 2. how we can compare objects, then use a sort method internally based on
 * some sorting algorithm(s) we studied.
 * 3. If you picked up on some of the more advanced things, that is great
 * but not totally necessary at this time.
 * 4. Look how much you know. You are champs in waiting.
 */

public class Employee implements Comparable {

	private String firstName;
	private String lastName;
	private String id;
	private String dept;
	private int code;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String id, String dept, int code) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.dept = dept;
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Object o) {

		Employee emp = null;
		if (o instanceof Employee) {
			emp = (Employee)o;
			if (this.lastName.compareTo(emp.getLastName()) == 0) {
				return this.firstName.compareTo(emp.getFirstName());
			}
		}
		return this.lastName.compareTo(emp.lastName);
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
