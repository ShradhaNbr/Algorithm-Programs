package com.bridgelabz;

import java.util.*;

public class PrimePalindromeAnagram {

	/**
	 * Purpose: Method to get prime numbers.
	 * 
	 * @param lower
	 * @param upper
	 */
	private static void checkPrime(int lower, int upper) {
		int flag = 0;
		ArrayList<String> arrayList = new ArrayList<>();

		for (int i = lower; i <= upper; i++) {
			if (i == 1 || i == 0)
				continue;
			flag = 1;

			for (int j = 2; j <= i / 2; ++j) {
				if (i % j == 0) {
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				System.out.print(i + " ");
				arrayList.add(Integer.toString(i));
			}
		}
		System.out.println();
		isAnagram(arrayList);
		isPalindromePair(arrayList);
	}

	/**
	 * Purpose: Method to print all anagrams between entered range.
	 * 
	 * @param array
	 */
	private static void isAnagram(ArrayList<String> array) {

		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < array.size(); i++) {
			String word = array.get(i);
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String newWord = new String(letters);
			if (map.containsKey(newWord)) {
				map.get(newWord).add(word);
			} else {
				List<String> words = new ArrayList<>();
				words.add(word);
				map.put(newWord, words);
			}
		}

		System.out.println("Prime numbers that are Anagrams are: ");
		for (String s : map.keySet()) {
			List<String> values = map.get(s);
			if (values.size() > 1) {
				System.out.print(values);
			}
		}
		System.out.println();
	}

	/**
	 * Purpose: Boolean method to check Palindrome number.
	 * 
	 * @param num
	 */
	private static boolean isPalindrome(String num) {
		int len = num.length();
		for (int i = 0; i < len / 2; i++)
			if (num.charAt(i) != num.charAt(len - i - 1))
				return false;
		return true;
	}

	/**
	 * Purpose: Method check for Palindrome pair and print it.
	 * 
	 * @param array
	 */
	private static boolean isPalindromePair(List<String> array) {
		boolean flag = false;
		System.out.println("\n" + "Palindrome numbers");
		for (int i = 0; i < array.size() - 1; i++) {
			if (isPalindrome(array.get(i))) {
				System.out.print(array.get(i) + " ");
				flag = true;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// User input for lower and upper bound.
		System.out.print("Enter lower bound of the interval: ");
		int lowerBound = sc.nextInt();

		System.out.print("Enter upper bound of the interval: ");
		int upperBound = sc.nextInt();

		System.out.println("Prime numbers between " + lowerBound + " and " + upperBound + " are: ");
		checkPrime(lowerBound, upperBound);
		sc.close();

	}

}