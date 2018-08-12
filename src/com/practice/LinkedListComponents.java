package com.practice;

import com.practice.common.ListNode;

import java.util.stream.IntStream;

public class LinkedListComponents {
    public int numComponents(ListNode<Integer> head, int[] G) {
        int count = 0;
        while (head != null) {
            int v = head.val;

            boolean contains = IntStream.of(G).anyMatch(x -> x == v);

            if (contains) {
                count++;
                head = getEnd(head.next, G);
            } else {
                head = head.next;
            }
        }

        return count;
    }

    private ListNode<Integer> getEnd(ListNode<Integer> start, int[] G) {
        while (start != null) {
            int v = start.val;

            boolean contains = IntStream.of(G).anyMatch(x -> x == v);
            if (contains) {
                start = start.next;
            } else {
                return start.next;
            }
        }
        return null;
    }
}
