package com.hcl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* Could use better method names for test classes rather than Edabit method names.
 * Test edge cases like negative ages.
 * Probably do not need this many positive age tests.
 */
public class AgeTestsJUnit5 {
	
	@DisplayName("First Test")
	@Test
	public void test01() throws Exception {
		assertEquals(Age.calcAge(10), 3650);
	}
	
	@DisplayName("Test for an age of zero")
	@Test
	public void testZeroAge() throws Exception {
		assertEquals(Age.calcAge(0), 0);
	}
	
	@Test
	public void test03() throws Exception {
		assertEquals(Age.calcAge(73), 26645);
	}
	
	@Test
	public void test04() throws Exception {
		assertEquals(Age.calcAge(20), 7300);
	}
	
	@Test
	public void test05() throws Exception {
		assertEquals(Age.calcAge(40), 14600);
	}
	
	@Test
	public void test06() throws Exception {
		assertEquals(Age.calcAge(66), 24090);
	}
	
	/* Use lambda instead of anon. inner class for run() method. Don't worry if we haven't covered
	 * details about exceptions, lambdas and streams, other things yet. We just want a high level
	 * thinking view now.
	 */
	@Test
	public void assertThatNegativeAgeFails() {
		assertThrows(Exception.class, () -> {
			Age.calcAge(-12);
		});
	}
}

