package com.hcl.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BasicNIO {
	
	public static void main(String[] args) throws IOException {
		
		new BasicNIO().startIt();
	}

	private void startIt() throws IOException {
		
		Path path = Paths.get("C:/Temp");
		System.out.printf("toString: %s%n", path.toString());
		System.out.printf("getFileName: %s%n", path.getFileName());
		System.out.printf("getName(0): %s%n", path.getName(0));
		System.out.printf("getNameCount: %d%n", path.getNameCount());
		System.out.printf("subpath(0,1): %s%n", path.subpath(0, 1));
		System.out.printf("getParent: %s%n", path.getParent());
		System.out.printf("getRoot: %s%n", path.getRoot());
		path.forEach(System.out::println);
		System.out.println(Files.find(path, Integer.MAX_VALUE, (t, u) -> 
			t.getFileName().toString().equalsIgnoreCase("access_denied.jpg")).count());
		
		// does not work for getting all files with path.forEach
		List<File> files = Files.list(path)
				.map(Path::toFile)
				.collect(Collectors.toList());
		files.forEach(System.out::println);
			
	}

}
