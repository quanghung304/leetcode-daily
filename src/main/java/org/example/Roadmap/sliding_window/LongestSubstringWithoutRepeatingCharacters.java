package org.example.Roadmap.sliding_window;

import java.util.HashMap;
import java.util.Map;
//89
public class LongestSubstringWithoutRepeatingCharacters {
    //Given a string s, find the length of the longest substring without repeating characters.
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring1(s));
    }
    //Normal approach: get sub string and then check if the sub string contain next character
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int left = 0, right = 1;
        int max = 0;
        String subS;

        while(left <= right && right < s.length()) {
            subS = s.substring(left, right);
            char c = s.charAt(right);

            if (subS.indexOf(c) < 0) {
                right++;
                continue;
            }

            int lenght = subS.length();
            if (lenght > max) {
                max = lenght;
            }

            if (left == right) {
                right++;
            } else {
                left++;
            }
        }

        subS = s.substring(left, right);
        if (subS.length() > max) {
            return subS.length();
        }

        return max;
    }
    //Optimize: use a hashMap to store the character and its position (index), left and right pointer to keep track on the length of the substring.
    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right=0; right < s.length(); right++) {
            Character c = s.charAt(right);

            if (map.containsKey(c)) {
                //if index of c < left, it means c doesn't belong to the current substring so we continue with the current left pointer
                //if not, we take c's index as the start of our new string
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
