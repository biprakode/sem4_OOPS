package Assignment2.q7;

import java.util.Arrays;

public class Main {
    public static void main() {
        String myString = "This is a and string this string and has multiple string this time madam racecar biprarshi@gmail.com";

        char target = 'a';
        long count = myString.chars().filter(ch -> target == ch).count();
        System.out.println("a appears = " + count);

        String strTarget = "and";
        String stringWithoutTarget = myString.replace(String.valueOf(target), "");
        int strCount = (myString.length() - stringWithoutTarget.length()) / strTarget.length();
        System.out.println("and appears = " + strCount);

        boolean the = myString.startsWith("the");
        System.out.println("Starts with the? " +  the);

        String[] chars = myString.split("");
        System.out.println(Arrays.toString(chars));

        String[] wordsdot = myString.split("[\\s+.@]");
        System.out.println(Arrays.toString(wordsdot));

        int maxLen = -1;
        String maxPalindrome = "";
        for (String word : myString.split("\\s+")) {
            if(isPalindrome(word)) {
                if(maxLen < word.length()) {
                    maxLen = word.length();
                    maxPalindrome = word;
                }
            }

        }
        System.out.println(STR."Max palindrome:- \{maxPalindrome}");

    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
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
