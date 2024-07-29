package org.example.Roadmap.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//accepted. 94%
public class TimeBasedKeyValueStore {
    //Design a time-based key-value data structure that can store multiple values for the same key at different time stamps
    // and retrieve the key's value at a certain timestamp.
    //Implement the TimeMap class:
    //
    //TimeMap() Initializes the object of the data structure.
    //void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
    //String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If
    //there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
    public static void main(String[] args) {
        String []action = {"set","set","get","get","get","get","get"};
        String[][] values = {{"love","high", String.valueOf(10)},{"love","low", String.valueOf(20)},

    {"love", String.valueOf(5)},{"love", String.valueOf(10)},{"love", String.valueOf(15)},{"love", String.valueOf(20)},{"love", String.valueOf(25)}};

        TimeMap timeMap = new TimeMap();

        for (int i=0; i<action.length; i++) {
            switch (action[i]) {
                case "set":
                    String[] set = values[i];
                    timeMap.set(set[0], set[1], Integer.parseInt(set[2]));
                    break;
                case "get":
                    String[] get = values[i];
                    System.out.println(timeMap.get(get[0], Integer.parseInt(get[1])));
                    break;
                default:
                    continue;
            }
        }
    }

    static class TimeMap {
        Map<String, ArrayList<String>> keyValue = new HashMap<>();
        Map<String, ArrayList<Integer>> keyTime = new HashMap<>();

        public TimeMap() {}

        public void set(String key, String value, int timestamp) {
            ArrayList<String> keyValues = keyValue.getOrDefault(key, new ArrayList<>());
            keyValues.add(value);
            keyValue.put(key, keyValues);

            ArrayList<Integer> keyTimeArray = keyTime.getOrDefault(key, new ArrayList<>());
            keyTimeArray.add(timestamp);
            keyTime.put(key, keyTimeArray);
        }

        public String get(String key, int timestamp) {
            int index = search(keyTime.get(key), timestamp);
            if (index == -1) {
                return "";
            }
            return keyValue.get(key).get(index);
        }

        public static int search(ArrayList<Integer> nums, int target) {
            if (Objects.isNull(nums)) {
                return -1;
            }

            int left = 0;
            int right = nums.size() - 1;

            if (target < nums.get(left)) {
                return -1;
            }

            if (target > nums.get(right)) {
                return right;
            }

            int middle;

            while (left <= right) {
                middle = (right + left) / 2;

                if (nums.get(middle) == target) {
                    return middle;
                } else if (nums.get(middle) > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            //sau vong while, right < left => num[right] < target < nums[left]
            return right;
        }
    }
}
