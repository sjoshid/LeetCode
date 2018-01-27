package com.practice;

import com.practice.common.ListNode;

public class SwapPairs {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode<Integer> head) {
        ListNode<Integer> returnMe = head;

        while(head != null) {
            ListNode<Integer> f = head;
            ListNode<Integer> s = f.next;
            ListNode<Integer> nf = null;
            if(s != null) {
                nf = s.next;

                s.next = f;
                f.next = nf;
            }

            head = nf;
        }

        return returnMe;
    }
}
