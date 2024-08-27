package org.example.DataStructure;

public class DoublyNode {
        public int key;
        public int val;
        public DoublyNode next;
        public DoublyNode prev;

        public DoublyNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
}

