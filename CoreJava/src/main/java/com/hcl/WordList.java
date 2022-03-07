package com.hcl;

/*
This could be done in other ways.
*/
public class WordList {

	public static boolean isSorted(String[] w, String l) {

		for (int i = 0; i < w.length - 1; i++) {
			for (int j = i + 1; j < w.length; j++) {
				if (compareWords(w[i], w[j], l) > 0)
					return false;
			}
		}
		return true;
	}

	static int compareWords(String oneString, String anotherString, String l) {
		int len1 = oneString.length();
		int len2 = anotherString.length();
		int lim = Math.min(len1, len2);
		int k = 0, l1 = 0, l2 = 0;
		while (k < lim) {
			l1 = l.indexOf(oneString.charAt(k));
			l2 = l.indexOf(anotherString.charAt(k));
			if (l1 != l2) {
				return l1 - l2;
			}
			k++;
		}
		return len1 - len2;
	}
}
