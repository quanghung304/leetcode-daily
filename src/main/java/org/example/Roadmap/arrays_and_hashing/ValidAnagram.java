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
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapCombine = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            Integer numChar = (Integer) mapS.get(c);

            if (numChar == null) {
                mapS.put(c, 1);
            } else {
                mapS.put(c, numChar + 1);
            }
        }

        String combine = s + t;
        for (int i=0; i<combine.length(); i++) {
            char c = combine.charAt(i);
            Integer numChar = (Integer) mapCombine.get(c);

            if (numChar == null) {
                mapCombine.put(c,1);
            } else {
                mapCombine.put(c, numChar + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: mapS.entrySet()) {
            Character c = entry.getKey();
            Integer countS = entry.getValue();

            Integer countT = mapCombine.get(c);

            if (countT == null || countS * 2 != countT) {
                return false;
            }
        }

        return true;
    }
}
