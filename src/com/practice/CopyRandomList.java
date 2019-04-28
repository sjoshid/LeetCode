package com.practice;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class CopyRandomList {
    Node head;

    public Node copyRandomList(Node head) {
        this.head = head;
        Node dh = deepCopy(head);
        Node startDh = dh;

        while(startDh != null) {
            startDh.random = getRandom(dh, startDh.random.val);
            startDh = startDh.next;
        }
        return dh;
    }

    public Node deepCopy(Node n) {
        if(n != null) {
            int positionOfRandom = findRandom(n.random, this.head);
            Node randomNode = new Node(positionOfRandom, null, null);
            return new Node(n.val, deepCopy(n.next), randomNode);
        } else {
            return null;
        }
    }

    public int findRandom(Node identifier, Node c) {
        int i = 0;
        while(c != null && identifier != null) {
            if(identifier == c) {
                return i;
            }
            c = c.next;
            i++;
        }
        return -1;
    }

    public Node getRandom(Node head, int position){
        if(position != -1) {
            int i = 0;
            while(i != position) {
                head = head.next;
                i++;
            }
            return head;
        }
        return null;
    }
}
