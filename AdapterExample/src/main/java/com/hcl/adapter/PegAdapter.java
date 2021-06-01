package com.hcl.adapter;

public class PegAdapter {
	
	private RoundPeg rdPeg;
	
	public PegAdapter(RoundPeg rdPeg) {
		this.rdPeg = rdPeg;
	}
	
	public void insert(String pgAdptr) {
		rdPeg.insertIntoHole(pgAdptr); // client does not see how insertion is completed
	}

}
