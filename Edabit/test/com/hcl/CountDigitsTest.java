package com.hcl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountDigitsTest {

	@Test
	public void test01() { 
		assertEquals(1, LongDigits.digitsCount(0));
	}

	@Test
	public void test02() { 
		assertEquals(4, LongDigits.digitsCount(4666));
	}

	@Test
	public void test03() { 
		assertEquals(3, LongDigits.digitsCount(544));
	}

	@Test
	public void test04() { 
		assertEquals(6, LongDigits.digitsCount(121317));
	}

	@Test
	public void test05() { 
		assertEquals(5, LongDigits.digitsCount(12345));
	}

	@Test
	public void test06() { 
		assertEquals(13, LongDigits.digitsCount(1289396387328L));
	}

	@Test
	public void test07() { 
		assertEquals(7, LongDigits.digitsCount(-1232323));
	}

	@Test
	public void test08() { 
		assertEquals(16, LongDigits.digitsCount(3463463874638476L));
	}

	@Test
	public void test09() { 
		assertEquals(9, LongDigits.digitsCount(-231200000));
	}

	@Test
	public void test10() { 
		assertEquals(13, LongDigits.digitsCount(1283939312321L));
	}

	@Test
	public void test11() { 
		assertEquals(9, LongDigits.digitsCount(-231273683));
	}

	@Test
	public void test12() { 
		assertEquals(7, LongDigits.digitsCount(3200000));
	}

	@Test
	public void test13() { 
		assertEquals(9, LongDigits.digitsCount(314890000));
	}


}
