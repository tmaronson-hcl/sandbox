package com.hcl.factory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;

public class JavaFactoryApiOthers {

	public static void main(String[] args) {
		
		JavaFactoryApiOthers jf = new JavaFactoryApiOthers();
		jf.calc();
		try {
			jf.showDecEx();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void showDecEx() throws IOException {
		
		// What about another design pattern we have used? Let's look at IO for example.
		/*
		 * Recall Reader, Writer, InputStream, OutputStream
		 * We could use what we know about OOP, inheritance to make this API more versatile, reusable,
		 * extensible, powerful in general.
		 * We could use the API to read from STDIN, files for example without changing much
		 * of the code. Now we can also use this for an URL.
		 */
		URL url = new URL("https://www.ibm.com/us-en?ar=1"); // like Decorator pattern?
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		  // could use FileReader with BR, System.in
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
			
		}
		br.close();
	}

	// factory pattern
	private void calc() {
		
		// Can we find an Java API example of some sort of factory pattern?
		
		double h = 4.5;
		double w = 12.5;
		double area = h*w;
		//NumberFormat nf2 = new NumberFormat();
		NumberFormat nf = NumberFormat.getInstance(); // returns an instance - hide away creation of instance, abstraction
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		System.out.println(nf.format(area));
		//DateFormat df = DateFormat.getDateInstance();
		
	}

}
