package com.hcl.io;

import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStreamExample {

	public static void main(String[] args) throws IOException {

		DataInputStream dis = new DataInputStream(System.in);
		System.out.print("Enter name: ");
		String name = dis.readLine(); // deprecated but recognizes CRLF
		System.out.print("Enter age: ");
		int age = Integer.parseInt(dis.readLine());
		System.out.printf("Name is %s and age is %d", name, age);
		dis.close();
	}

}
