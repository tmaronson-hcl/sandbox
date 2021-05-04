package com.hcl.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;

public class CauseExceptionExample {

	public static void main(String[] args) throws GeneralCustomException {
		
		new CauseExceptionExample().init();

	}

	private void init()  throws GeneralCustomException {
		
		/* try with resources does not require finally block with close method to close stream and big mess
		 * with additional try catch blocks in finally block - more on this later
		 */
		try (BufferedReader br = new BufferedReader(new FileReader("./nonsensefile.txt"));) {
			// maybe some other exceptions can happen here so catch general Exception
		} catch (Exception ex) {
			throw new GeneralCustomException("something is wrong here", ex);  // actual exception cause?
		}
		finally {
			// avoid close method mess here
		}
	}

}
