package com.hcl.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestAppSerialize {

	public static void main(String[] args) {
		
		StudentInfo si = new StudentInfo("Abbi", 104, "1238769");
		try {
			FileOutputStream fos = new FileOutputStream("./student.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(si);
			oos.close(); // better to refactor this in finally?
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// may need to add later
		}
	}

}
