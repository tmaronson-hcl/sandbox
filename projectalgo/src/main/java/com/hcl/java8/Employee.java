package com.hcl.java8;

public class Employee  {
	private int empNo;
	private String empName;
	private Float salary;
	private char band;
	public Employee() {
		super();
	}
	public Employee(int empNo, String empName, float salary, char band) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
		this.band = band;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public char getBand() {
		return band;
	}
	public void setBand(char band) {
		this.band = band;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + ", band=" + band + "]";
	}
	
	/*@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(o1.getSalary() > o2.getSalary()) {
			return 1;
		} else if(o1.getSalary() < o2.getSalary()) {
			return -1;
		} else {
			return 0;
		}
	}*/
}
