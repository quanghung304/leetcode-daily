package org.example.Roadmap.sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//41
public class PermutationInString {
    //Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    //
    //In other words, return true if one of s1's permutations is the substring of s2.
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }
    //approach: create a window on s2 with the length equals to s1's lenght. Move the window one by one and check if it's a permutation of s1 or not.
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            Character c = s1.charAt(i);
            Integer amount = map1.getOrDefault(c, 0);
            map1.put(c, amount+1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<s1.length(); i++) {
            Character c = s2.charAt(i);
            Integer amount = map2.getOrDefault(c, 0);
            map2.put(c, amount+1);
        }

        int left=0, right= left + s1.length()-1;
        while (right < s2.length()) {
            boolean result = true;
            for (Map.Entry entry : map1.entrySet()) {
                Character c = (Character) entry.getKey();

                if (entry.getValue().equals(map2.get(c))) {
                    continue;
                } else {
                    result = false;
                    break;
                }
            }

            if (result) return true;

            Character charLeft = s2.charAt(left);
            Integer leftIn2 = map2.get(charLeft);
            if (Objects.nonNull(leftIn2) && leftIn2 > 0) {
                map2.put(charLeft, leftIn2-1);
            }
            left++;

            right++;
            if (right == s2.length()) return false;
            Character charRight = s2.charAt(right);
            Integer rightIn2 = map2.getOrDefault(charRight, 0);
            map2.put(charRight, rightIn2+1);
        }

        return false;
    }
}
