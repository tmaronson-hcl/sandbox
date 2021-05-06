package com.hcl.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {
		
		System.out.print("Enter name: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		System.out.printf("Name is %s", name);
		reader.close();
	}

}
