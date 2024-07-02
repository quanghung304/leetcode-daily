package org.example.Roadmap.two_pointers;

import java.util.ArrayList;
import java.util.List;
//accepted. beats 55%
public class ValidPalindrome {
    //A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
    //non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    //
    //Given a string s, return true if it is a palindrome, or false otherwise.
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        List<Character> characters = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            if (
                    (s.charAt(i) > 96 && s.charAt(i) < 123)
                    || (s.charAt(i) > 47 && s.charAt(i) < 58)
            ) {
                characters.add(s.charAt(i));
            }
        }

        int size = characters.size();
        int mid = size/2+1;

        for (int i=0; i<mid; i++) {
            if (!characters.get(i).equals(characters.get(size-i-1))) {
                return false;
            }
        }

        return true;
    }
}
