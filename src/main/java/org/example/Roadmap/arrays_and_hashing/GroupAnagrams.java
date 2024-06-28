package org.example.Roadmap.arrays_and_hashing;

import java.util.*;

public class GroupAnagrams {
    //Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    //
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    public static void main(String[] args) {
        String[] strgs = new String[]{"eat","tea","tan","ate","nat","bat"};

//        Arrays.sort(strgs);
//        for (String s: strgs) {
//            System.out.println(s);
//        }

        for (List<String> strings: groupAnagrams(strgs)) {
            String result = "";
            for (String s: strings) {
                result += s;
            }
            System.out.println(result);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);

//            List<String> strings = map.getOrDefault(key, new ArrayList<>());
//            strings.add(s);
//            map.put(key, strings);
//            cham hon do buoc put them strings vao map.
        }

        return new ArrayList<>(map.values());
    }
}
