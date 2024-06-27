package org.example.Roadmap.arrays_and_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidAnagram {
    //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    //
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char x: s.toCharArray()) {
            count[x - 'a'] ++;
        }

        for (char x: t.toCharArray()) {
            count[x - 'a'] --;
        }

        for (int i: count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
