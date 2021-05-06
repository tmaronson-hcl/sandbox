package com.hcl.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeTest {

	public static void main(String[] args) {

		StudentInfo si = null;
		try {
			FileInputStream fis = new FileInputStream("student.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			si = (StudentInfo) in.readObject();
			fis.close(); // refactor this in finally?
			in.close();
		} catch ( ClassNotFoundException | IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println(si);
	}

}
