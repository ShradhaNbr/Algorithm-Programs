package com.Anagram;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	/*
	 * Purpose: Method to check whether 2 strings are Anagram.
	 * 
	 * @param str1.
	 * @param str2.
	 */
	public static void isAnagram(String str1, String str2) {
		// Converting both the string to lower case.
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// Checking for the length of strings
		if (str1.length() != str2.length()) {
			System.out.println("Both the strings are not anagram");
		} else {
			// Converting both the arrays to character array
			char[] string1 = str1.toCharArray();
			char[] string2 = str2.toCharArray();

			// Sorting the arrays using in-built function sort ()
			Arrays.sort(string1);
			Arrays.sort(string2);

			// Comparing both the arrays using in-built function equals ()
			if (Arrays.equals(string1, string2) == true) {
				System.out.println("Both the strings are anagram");
			} else {
				System.out.println("Both the strings are not anagram");
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// User input for strings.
		System.out.println("Enter 2 strings: ");
		String str1 = sc.next();
		String str2 = sc.next();
		isAnagram(str1, str2);
		sc.close();

	}
}