package com.hcl.domain;

public class Employee implements Comparable<Employee> {
	
	private String fName;
	private String lName;
	private int score;
	
	// non default constructor
	public Employee(String fName, String lName, int score) {
		super();  //?? calls Object default ctor
		this.fName = fName;
		this.lName = lName;
		this.score = score;
	}
	
	public Employee() {
		
		this.fName = "";
		this.lName = "";
		this.score = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + score;
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
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Employee [fName = " + fName + ", lName = " + lName + ", "
				+ "score = " + score + "]";
	}

	@Override
	public int compareTo(Employee other) {
		
		//return other.score - this.score; // order based on score - inc./dec.
		// based on lexicographical order - inc./dec.
		return this.lName.compareTo(other.lName);  
	}
	
	
	
	
	
	

}
