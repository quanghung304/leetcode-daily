package org.example.Roadmap.sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//5
public class MinimumWindowSubstring {
    //Given two strings s and t of lengths m and n respectively, return the minimum window substring
    // of s such that every character in t (including duplicates) is included in the window. If there is no such substring,
    // return the empty string "".
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow1(s, t));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> mapT = new HashMap<>();

        for (int i=0; i<t.length(); i++) {
            Character c = t.charAt(i);
            Integer amount = mapT.getOrDefault(c, 0);
            mapT.put(c, amount+1);
        }

        int left=0;
        while (left < s.length()) {
            Character c = s.charAt(left);
            if (!mapT.containsKey(c)) {
                left++;
            } else {
                break;
            }
        }

        int right = left, min = s.length();
        String ans = "";
        Map<Character, Integer> mapS = new HashMap<>();
        boolean recheck = false;

        while (left <= right && right < s.length()) {
            Character c = s.charAt(right);
            if (!recheck && mapT.containsKey(c)) {
                Integer amountInS = mapS.getOrDefault(c, 0);
                mapS.put(c, amountInS+1);
            } else if (!recheck) {
                right++;
                continue;
            }

            boolean result = true;
            for (Map.Entry entry: mapT.entrySet()) {
                Character key = (Character) entry.getKey();
                if (Objects.nonNull(mapS.get(key)) && mapS.get(key) >= (int) entry.getValue()) {
                } else {
                    result = false;
                    break;
                }
            }

            if (result) {
                if (right-left+1 <= min) {
                    min = right-left+1;
                    ans = s.substring(left, right+1);
                }

                Character charLeft = s.charAt(left);
                Integer amountLeft = mapS.get(charLeft)-1;
                mapS.put(charLeft, amountLeft);

                left++;
                while (left < right) {
                    Character curChar = s.charAt(left);
                    if (!mapT.containsKey(curChar)) {
                        left++;
                    } else {
                        break;
                    }
                }
                recheck = true;
            } else {
                right++;
                recheck = false;
            }
        }

        return ans;
    }

    public static String minWindow1(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) map[c]++;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;

            while (count == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }

                if (map[s.charAt(start++)]++ == 0) count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
