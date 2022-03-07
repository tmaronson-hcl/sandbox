package com.hcl;

public class WordListClient {

	public static void main(String[] args) {

		String alphabet1 = "ewbazhyjkxugtnmvprsodqcilf";
		String[] words = new String[]{"world", "word", "apple"};
		System.out.println(WordList.isSorted(words, alphabet1));
		String[] words2 = {"word", "world", "worm"};
		System.out.println(WordList.isSorted(words2, alphabet1));
		String[] words3 = {"worm", "word", "world"};
		System.out.println(WordList.isSorted(words3, alphabet1));

	}						  

}
