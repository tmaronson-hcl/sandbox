package com.hcl.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderExample {  
	
	/*
	 * Check docs for File, Files, Path, Paths
	 */

	public static void main(String[] args) throws IOException {
		
		String fileName = "./example.txt";		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		FileWriter fw = new FileWriter(new File("./writer.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			fw.write(line + "\n");
			System.out.println(line);
		}
		br.close();
		fw.close();
	}

}
