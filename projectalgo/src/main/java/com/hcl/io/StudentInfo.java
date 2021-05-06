package com.hcl.io;

import java.io.Serializable;

public class StudentInfo implements Serializable {

	
	private static final long serialVersionUID = -5770396014133863222L;
	
	

	private String name;
	private transient int rid;
	private String contact;

	public StudentInfo(String name, int rid, String contact) {
		this.name = name;
		this.rid = rid;
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return "StudentInfo [name=" + name + ", rid=" + rid + ", contact=" + contact + "]";
	}


}
