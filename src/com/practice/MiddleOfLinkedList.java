package com.practice;

import com.practice.common.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode n1 = head;
        ListNode n2 = head;

        while (n1.next != null) {
            n1 = n1.next;

            if (n2.next != null) {
                n2 = n2.next;
            }

            if (n2.next != null) {
                n2 = n2.next;
            }

            if (n2 == null || n2.next == null) {
                return n1;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        MiddleOfLinkedList m = new MiddleOfLinkedList();
    }
}
