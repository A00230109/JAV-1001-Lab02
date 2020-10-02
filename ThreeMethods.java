/*
 * Author:      Youssef NAFAA
 * College:     Cambrian
 * Date   :     September 20/2020
 * Last Update: October   01/2020
 * Program:     Three methods to choose at the input
 * 				Encryption/Decryption, Sum of elements of an array
 * 				and check if an array contains an element 
 */

import java.util.Scanner;

public class ThreeMethods {

	public static void main(String[] args) {
		
		System.out.println("Choose The Method You Want To Run: ");
		System.out.println("1: Encryption/Decryption: ");
		System.out.println("2: Sum Of Elements Array: ");
		System.out.println("3: If Array Contains A Specific Number: ");
		Scanner scanner = new Scanner(System.in);		
		// The user is asked to input 1 or 2 or 3 as choice 
		// the program will loop if not
		int nbChoice = 0;
		do {
			nbChoice = scanner.nextInt();
			if (nbChoice == 1) {
				encryptionDecryption();
			}
			else if(nbChoice == 2) {
				sumElementsOfArray();
			}
			else if (nbChoice == 3) {
				arrayContainsSpecificNumber();
			}
			else {
				System.out.println("Enter a number between 1 and 3: ");
			}
			
		}while(nbChoice<=0 || nbChoice>3);
		scanner.close();
	}
	
	/* Encryption/Decryption method that gets a string from the user and encrypt value
	 * we just add the encrypt value to each char of the string but if this value
	 * is bigger than 25 we reduce it inside a loop until the value is <= 25 
	 */
	private static void encryptionDecryption() {
		Scanner scanner = new Scanner(System.in);
		String stringToEncrypt;
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean stringIsValid;
		String str;
		do {
			System.out.println("Enter a String to Encrypt without spaces: ");
			stringIsValid = true;
			stringToEncrypt = scanner.nextLine();
			for(int i=0; i<stringToEncrypt.length(); i++) {
				str = stringToEncrypt.charAt(i)+"";
				if (!alphabet.contains(str)){
					stringIsValid = false;
					break;
				}
			}
		}while(stringIsValid == false);
		int encryptValue;
		System.out.println("Enter Encrypt Value: ");
		encryptValue = scanner.nextInt();
		if (encryptValue > 25) {
			do {
				encryptValue = encryptValue-26;
			}while(encryptValue > 25);
		}
		char[] stringEncrypted = new char[stringToEncrypt.length()];
		char[] stringDecrypted = new char[stringToEncrypt.length()];
		int intAscii2=0;
		for(int i=0; i<stringToEncrypt.length(); i++) {
			char extractChar = stringToEncrypt.charAt(i);
			int intAscii = (int)extractChar;
			if(intAscii >= 65 && intAscii <= 90){
				intAscii2 = intAscii + encryptValue;
				if(intAscii2 > 90) {
					intAscii2 = intAscii2 - 26; 
				}
			}
			if(intAscii >= 97 && intAscii <= 122) {
				intAscii2 = intAscii + encryptValue;
				if(intAscii2 > 122) {
					intAscii2 = intAscii2 - 26; 
				}
			}
			stringEncrypted[i] = (char)intAscii2;			
		}
		System.out.println("String Encrypted: ");
		for (char c : stringEncrypted) {
			System.out.print(c);
		}
		
		for(int i=0; i<stringEncrypted.length; i++) {
			char extractChar = stringEncrypted[i];
			int intAscii = (int)extractChar;
			if(intAscii >= 65 && intAscii <= 90){
				intAscii2 = intAscii - encryptValue;
				if(intAscii2 < 65) {
					intAscii2 = intAscii2 + 26; 
				}
			}
			if(intAscii >= 97 && intAscii <= 122) {
				intAscii2 = intAscii - encryptValue;
				if(intAscii2 < 97) {
					intAscii2 = intAscii2 + 26; 
				}
			}
			stringDecrypted[i] = (char)intAscii2;			
		}
		System.out.println();
		System.out.println("String Decrypted: ");
		for (char c : stringDecrypted) {
			System.out.print(c);
		}
		scanner.close();
		
	}
 
	private static void sumElementsOfArray() {
		System.out.println("Enter the nbre of the elements of the array: ");
		Scanner scanner = new Scanner(System.in);

		int howManyElements = scanner.nextInt();
		int[] arrayElements = new int[howManyElements];
		System.out.println("The Elements Of The Array Are:");
		for(int i=0; i<howManyElements; i++) {
			arrayElements[i] =(int)(Math.random() * 100);
			System.out.print(arrayElements[i] +" ");
		}
		System.out.println();
		System.out.print("The Sum Of The Elements Of The Array is: ");
		System.out.println(sumOfElementsOfArray(arrayElements));
		scanner.close();
	}
	
	
	private static void arrayContainsSpecificNumber() {
		System.out.println("Enter the nbre of the elements of the array: ");
		Scanner scanner = new Scanner(System.in);

		int howManyElements = scanner.nextInt();
		int[] arrayElements = new int[howManyElements];
		System.out.println("The Elements Of The Array Are:");
		for(int i=0; i<howManyElements; i++) {
			arrayElements[i] =(int)(Math.random() * 100);
			System.out.print(arrayElements[i] +" ");
		}
		System.out.println("Enter the number to check existence of: ");
		int whichNumber = scanner.nextInt();
		boolean nbrFound = false;
		for(int i=0; i<howManyElements; i++) {
			if (arrayElements[i] == whichNumber) {
				nbrFound = true;
				break;
			}
		}
		
		if(nbrFound) 
			System.out.println("Number "+whichNumber+ " found"); 
		else
			System.out.println("Number "+whichNumber+ " not found");
		
		scanner.close();
	}
	
	private static int sumOfElementsOfArray(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
