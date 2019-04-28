package com.practice;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class ReverseList {
     ListNode newHead;
    public ListNode reverseList(ListNode head) {
        ListNode chead = head;
        //reverseRecursively(chead, chead.next);
        reverseIteratively(head);
        return newHead;
    }

    private void reverseRecursively(ListNode head, ListNode next) {

        if(next != null){
            reverseRecursively(head.next, next.next);
            head.next.next = head;
            head.next = null;
        } else {
            newHead = head;
        }
    }

    private ListNode reverseIteratively(ListNode current) {
        ListNode dummy;
        ListNode pre = null;
        while(current != null) {
            dummy = current.next;
            current.next = pre;
            pre = current;
            current = dummy;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode f = new ListNode(1);
        ListNode s = new ListNode(2);
        f.next = s;
        s.next = null;

        ReverseList rs = new ReverseList();
        rs.reverseIteratively(f);
    }
}
