package com.binarySearch;

public class BinarySerach {

	public static void main(String[] args) {
		String[] word = { "Binary", "search", "program", "practice" };
		String search = "search";
		int result = binarySearch(word, search);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element present at index " + result);

	}
/*
 * Purpose : Method to search using Binary search
 * 
 * @Param word
 * 
 * @Param search
 */
	public static int binarySearch(String[] word, String search) {
		int first = 0, last = word.length - 1;
		while (first <= last) {
			int mid = first + (last - first) / 2;
			int result = search.compareTo(word[mid]);
			if (result == 0)
				return mid;
			if (result > 0)
				first = mid + 1;
			else
				last = mid - 1;
		}
		return -1;
	}

}
