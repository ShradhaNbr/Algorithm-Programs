package com.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		String s = "abc";
		List<String> strArray = new ArrayList<String>();
		System.out.println("Permutation using recursive method");
		recursive("", s, strArray);
		Collections.sort(strArray);
		System.out.println(strArray);
		System.out.println("\nPermutation using iterative method");
		List<String> strArrayIterative = iterative(s);
		Collections.sort(strArrayIterative);
		System.out.println(strArrayIterative);
		iterative(s);
		boolean result = strArray.equals(strArrayIterative);
		System.out.println(result);
	}
	/*
	 * Purpose: Method to generate all permutation of a string using iterative
	 * method
	 * 
	 * @param s
	 */
	private static List<String> iterative(String s) {
		List<String> partial = new ArrayList<>(); //create empty ArrayList to store(partial) permutation
		partial.add(String.valueOf(s.charAt(0)));//initialize the string with first character of the string
		for(int i=1;i<s.length();i++) {
			for(int j=partial.size()-1;j>=0;j--)// iterate backward to avoid ConcurrentModificationException
				{
				String str = partial.remove(j);
				for(int k=0;k<=str.length();k++) {
					partial.add(str.substring(0,k) + s.charAt(i) + str.substring(k));
				}
			}
		}
		return partial;
	}

	/*
	 * Purpose: Method to generate all permutation of a string using recursive
	 * method
	 * 
	 * @param prefix
	 * 
	 * @param remaining
	 * 
	 * @param strArray
	 */
	private static void recursive(String prefix, String remaining, List<String> strArray) {
		if (remaining.length() == 0) {
			strArray.add(prefix);
			return;
		}
		for (int i = 0; i < remaining.length(); i++) {
			String newPrefix = prefix + remaining.charAt(i);
			String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
			recursive(newPrefix, newRemaining,strArray);
		}
	}
}
