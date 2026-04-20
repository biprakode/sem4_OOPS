// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Take a String input that contains multiple words. Do the following:
//   i) number of times 'a' appears
//   ii) number of times "and" appears
//   iii) whether it starts with "The" or not
//   iv) put the String into an array of characters
//   v) display the tokens in the String (tokens are the substrings separated by space or @ or .)
//   vi) Find the largest palindrome in a given input sentence after removing any non-
//       alphanumeric character.

package Assignment2.q7;

import java.util.Arrays;

public class Main {
    public static void main() {
        // a working sample sentence for all the checks below
        String myString = "This is a and string this string and has multiple string this time madam racecar biprarshi@gmail.com";

        // (i) count occurrences of the letter 'a'
        char target = 'a';
        long count = myString.chars().filter(ch -> target == ch).count();
        System.out.println("a appears = " + count);

        // (ii) count the substring "and" - remove 'a' chars first so our offset maths works
        String strTarget = "and";
        String stringWithoutTarget = myString.replace(String.valueOf(target), "");
        int strCount = (myString.length() - stringWithoutTarget.length()) / strTarget.length();
        System.out.println("and appears = " + strCount);

        // (iii) does the sentence start with "the" ?
        boolean the = myString.startsWith("the");
        System.out.println("Starts with the? " + the);

        // (iv) explode the string into a character array
        String[] chars = myString.split("");
        System.out.println(Arrays.toString(chars));

        // (v) split on space, dot or @
        String[] wordsdot = myString.split("[\\s+.@]");
        System.out.println(Arrays.toString(wordsdot));

        // (vi) largest palindrome word in the sentence
        int maxLen = -1;
        String maxPalindrome = "";
        for (String word : myString.split("\\s+")) {
            if (isPalindrome(word)) {
                if (maxLen < word.length()) {
                    maxLen = word.length();
                    maxPalindrome = word;
                }
            }
        }
        System.out.println(STR."Max palindrome:- \{maxPalindrome}");
    }

    // simple two-pointer palindrome check
    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
