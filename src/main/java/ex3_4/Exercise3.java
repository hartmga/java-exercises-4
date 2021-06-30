package ex3_4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
3. Write a Java method to display the middle character of a string.  
	a) If the length of the string is even there will be two middle characters. 
	b) If the length of the string is odd there will be one middle character. 
 		Input a string: 367  
		Expected Output:                                                                     
			The middle character in the string: 6 
4. Write a Java method to count all vowels in a string.  
	Input the string: Hcl Technologies  
	Expected Output: 
		Number of  Vowels in the string: 5 
*/
public class Exercise3 {

	public static void main(String[] args) {

		System.out.println("Enter a string: ");
		Scanner in = new Scanner(System.in);
		String inputString = in.nextLine();
		displayMiddleCharacters(inputString);
		countVowels(inputString);

	}

	public static void displayMiddleCharacters(String s) {
		if (s == null || "".equals(s)) {
			System.out.println("There are no characters in the string");
		} else {
			String middle;
			int mid = (s.length()) / 2;

			// there are two middle characters if the string has even length
			if (s.length() % 2 == 0) {
				middle = s.substring(mid - 1, mid + 1);
				System.out.printf("The middle charaters in the string are: '%s'%n", middle);
			} else {
				middle = s.substring(mid, mid + 1);
				System.out.printf("the middle character in the string is: '%s'%n", middle);
			}
		}

	}

	public static final Set<Character> vowels = new HashSet<Character>(
			Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	public static void countVowels(String s) {
		int numVowels = (int) Arrays.stream(s.split("")).filter(c -> vowels.contains(c.charAt(0))).count();
		System.out.printf("Number of vowels in the string: %d%n", numVowels);
	}

}
