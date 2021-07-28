package com.guessnumber;

import java.util.Scanner;

public class guessNumber {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int low = 1;
		System.out.println("Enter upper limit");
		int high = sc.nextInt();
		System.out.println("Guess a number in range(1 to " + high + ")");
		guessNumber(low, high);
		sc.close();
	}

	private static void guessNumber(int low, int high) {
		while (low <= high) {
			int mid = (low + high )/ 2;
			System.out.println("press 0 if guess number is " + mid + " press 1. if less than " + mid + " press 2. if greater than " + mid);
			int choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Successfully guessed the number");
				System.exit(0);
				break;
			case 1:
				high = mid - 1;
				break;
			case 2:
				low = mid + 1;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}

}