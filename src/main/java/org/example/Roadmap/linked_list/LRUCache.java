package org.example.Roadmap.linked_list;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.example.DataStructure.CircularDoublyLinkedList.Node;
//97%
public class LRUCache {
    //Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
    //
    //Implement the LRUCache class:
    //
    //LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    //int get(int key) Return the value of the key if the key exists, otherwise return -1.
    //void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
    // If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    //The functions get and put must each run in O(1) average time complexity.
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode) {
        Node beforeTail = tail.prev;

        beforeTail.next = newNode;
        newNode.prev = beforeTail;

        newNode.next = tail;
        tail.prev = newNode;
    }

    public void removeNode (Node node) {
        Node before = node.prev;
        Node after = node.next;

        before.next = after;
        after.prev = before;
    }

    public int get(int key) {
        Node node = map.get(key);

        if (Objects.nonNull(node)) {
            removeNode(node);
            addNode(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.val = value;
            removeNode(node);
            addNode(node);
            return;
        }

        node = new Node(key, value);
        addNode(node);
        map.put(key, node);

        if (map.size() > capacity) {
            int evictedKey = head.next.key;
            removeNode(head.next);
            map.remove(evictedKey);
        }
    }

    public static void main(String[] args) {
//        String []action = {"LRUCache","put","put","get","put","get","put","get","get","get"};
//        int[][] values = {{2},{1,1}, {2,2},{1},{3,3},{2},{4,4},{1},{3},{4}};
//        String[] action = {"LRUCache","put","put","get","get","put","get","get","get"};
//        int[][] values = {{2},{2,1}, {3,2},{3},{2},{4,3},{2},{3},{4}};
        String[] action = {"LRUCache","put","put","put","put","get","get"};
        int[][] values = {{2}, {2,1},{1,1}, {2,3},{4,1},{1},{2}};
        LRUCache cache = null;

        for (int i=0; i<action.length; i++) {
            switch (action[i]) {
                case "LRUCache":
                    cache = new LRUCache(values[i][0]);
                    break;
                case "put":
                    cache.put(values[i][0], values[i][1]);
                    break;
                case "get":
                    System.out.println(cache.get(values[i][0]));
            }
        }
    }
}
