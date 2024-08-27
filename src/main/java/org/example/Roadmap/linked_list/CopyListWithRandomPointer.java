package org.example.Roadmap.linked_list;

import org.example.DataStructure.RandomNode;

import java.util.HashMap;
import java.util.Map;
//100%
public class CopyListWithRandomPointer {
    //A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
    //
    //Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has
    // its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes
    // should point to new nodes in the copied list such that the pointers in the original list and copied list represent
    // the same list state. None of the pointers in the new list should point to nodes in the original list.
    //
    //For example, if there are two nodes X and Y in the original list, where X.random --> Y,
    // then for the corresponding two nodes x and y in the copied list, x.random --> y.
    //
    //Return the head of the copied linked list.
    //
    //The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
    //
    //val: an integer representing Node.val
    //random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
    public static void main(String[] args) {
        Integer[][] nums = {{7,null},{13,0}, {11,4},{10,2},{1,0}};
        RandomNode head = RandomNode.createList(nums);
        RandomNode.printList(copyRandomList(head));

    }

    public static RandomNode copyRandomList(RandomNode head) {
        RandomNode current = head;
        RandomNode newHead = null, newCurrent = null;
        Map<RandomNode, RandomNode> map = new HashMap<>();

        while (current != null) {
            RandomNode newNode = new RandomNode(current.val);
            map.put(current, newNode);
            current = current.next;

            if (newCurrent == null) {
                newHead = newNode;
                newCurrent = newNode;
                continue;
            }

            newCurrent.next = newNode;
            newCurrent = newNode;
        }

        current = head;
        newCurrent = newHead;

        while (current != null) {
            RandomNode random = current.random == null ? null : map.get(current.random);
            newCurrent.random = random;

            current = current.next;
            newCurrent = newCurrent.next;
        }

        return newHead;
    }
}
