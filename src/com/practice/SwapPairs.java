package com.practice;

import com.practice.common.ListNode;

/**
 * Solution for https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapPairs {

    public static void main(String[] args) {

        SwapPairs sp = new SwapPairs();
        ListNode<Integer> h = new ListNode<>(1);
        ListNode<Integer> a = new ListNode<>(2);
        ListNode<Integer> b = new ListNode<>(3);
        ListNode<Integer> c = new ListNode<>(4);
        ListNode<Integer> d = new ListNode<>(5);
        ListNode<Integer> e = new ListNode<>(6);

        h.next = a;
        a.next = b;
        /*b.next = c;
        c.next = d;
        d.next = e;*/

        ListNode<Integer> r = sp.swapPairs(h);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }

    public ListNode swapPairs(ListNode<Integer> head) {

        if (head != null) {
            if(head.next != null) {
                ListNode<Integer> f = head;
                ListNode<Integer> returnMe = head.next, s = head.next;

                while (s != null) {
                    ListNode<Integer> nf = s.next;

                    s.next = f;
                    if (nf != null) {
                        if(nf.next != null) {
                            f.next = nf.next;
                        } else {
                            f.next = nf;
                        }
                        f = nf;
                        s = f.next;
                    } else {
                        f.next = null;
                        s = null;
                    }
                }
                return returnMe;
            }
            return head;
        }
        return null;
    }
}

