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
 * 5. Added equals method with hashCode method. These should be developed together.
 * 6. See Object class and Map class definition of hashCode.
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (code != other.code)
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
