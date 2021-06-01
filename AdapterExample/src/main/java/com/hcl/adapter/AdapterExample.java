package com.hcl.adapter;

public class AdapterExample {

	public static void main(String[] args) {

		SquarePeg sqPeg = new SquarePeg();
		sqPeg.insert("Successfully inserted square peg");
		PegAdapter pgAdptr = new PegAdapter(new RoundPeg());
		pgAdptr.insert("Successfully inserted round peg");
	}

}
