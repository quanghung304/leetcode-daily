package org.example.Roadmap.sliding_window;
//accepted
public class LongestRepeatingCharacterReplacement {
    //You are given a string s and an integer k. You can choose any character of the string and change it to any other
    //uppercase English character. You can perform this operation at most k times.
    //
    //Return the length of the longest substring containing the same letter you can get after performing the above operations.
    public static void main(String[] args) {
        String s = "ABAA";
        int k = 0;
        System.out.println(characterReplacement(s, k));
    }
    //approach: consider s = "BAAA", the longest string is AAAA as we change B to A. But how we know the first character (B) need to be replaced when A is after B?
    //especially when the range of characters is from A to Z
    //=> we must iterate through A to Z to see which substring from a character is the longest
    public static int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0, replaced = 0;
            while (j < n) {
                if (s.charAt(j) == c) {
                    j++;
                } else if (replaced < k) {
                    j++;
                    replaced++;
                } else if (s.charAt(i) == c) {
                    i++;
                } else {
                    i++;
                    replaced--;
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}
