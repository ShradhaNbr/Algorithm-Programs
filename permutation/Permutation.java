package com.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		String s = "abc";
		ArrayList<String> List = new ArrayList<String>();
		System.out.println("Permutation using recursive method");
		recursive("", s, List);
		Collections.sort(List);
		System.out.println(List);
		System.out.println("\nPermutation using iterative method");
		ArrayList<String> strArrayIterative = (ArrayList<String>) iterative(s);
		Collections.sort(strArrayIterative);
		System.out.println(strArrayIterative);
		iterative(s);
		boolean result = List.equals(strArrayIterative);
		System.out.println(result);
	}
	/*
	 * Purpose: Method to generate all permutation of a string using iterative
	 * method
	 * 
	 * @param s
	 */
	private static List<String> iterative(String s) {
		ArrayList<String> partial = new ArrayList<>(); //create empty ArrayList to store(partial) permutation
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
	 * @param prefix`
	 * 
	 * @param remaining
	 * 
	 * @param strArray
	 */
	private static void recursive(String word, String remaining, List<String> List) {
		
		if (remaining.length() == 0) {
			List.add(word);
			return;
		}
		for (int i = 0; i < remaining.length(); i++) {
			String newPrefix = word + remaining.charAt(i);
			String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
			recursive(newPrefix, newRemaining,List);
		}
	}
}
