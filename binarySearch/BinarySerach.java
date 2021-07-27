package com.binarySearch;

import java.util.Scanner;

public class BinarySerach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word[] = new String[10];
		System.out.println("Enter the word");
		for (int i = 0; i < word.length; i++) {
			word[i] = sc.next();
			System.out.println("Enter the word you want to search");
			String search = sc.next();
			int result = binarySearch(word, search);
			if (result == -1)
				System.out.println("Element not present");
			else
				System.out.println("Element present at " + "index" + result);
			sc.close();
		}
	}

	public static int binarySearch(String[] word, String search) {
		int l = 0, r = word.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int result = search.compareTo(word[m]);
			if (result == 0)
				return m;
			if (result > 0)
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}

}
