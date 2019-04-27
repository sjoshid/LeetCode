package com.practice;

import com.practice.common.BSTNode;

import java.util.Arrays;

public class ConstructFromPrePost {
    public static void main(String[] args) {
        ConstructFromPrePost c = new ConstructFromPrePost();
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};

        c.constructFromPrePost(pre, post);

    }
    /*public BSTNode constructFromPrePost(int[] pre, int[] post) {
        LinkedList<BSTNode<Integer>> l = new LinkedList<>();
        BSTNode<Integer> v = new BSTNode<>(pre[0]);
        l.add(v);

        for(int i = 1; i < pre.length; i++)
        {
            int c = pre[i];
            if(c == post[0])
            {
                //remove from post
                //add as left child of last element of l
                if(v.left == null)
                {
                    v.left = new BSTNode<>(c);
                    //v = v.left;
                }
                else
                {
                    v.right = new BSTNode<>(c);
                    //v = v.right;
                }
                pre = removeElementFromPre(c, pre);
                post = removeElementFromPost(c, post);
            }
            else
            {
                if(v.left == null)
                {
                    v.left = new BSTNode<>(c);
                    v = v.left;
                }
                else
                {
                    v.right = new BSTNode<>(c);
                    v = v.right;
                }
                l.add(v);
            }
        }
    }

    private int[] removeElementFromPre(int element, int[] pre){
        int [] afterPre = new int[pre.length - 1];
        int i = 0;
        for(int e: pre)
        {
            if(e != element)
            {
                afterPre[i++] = e;
            }
        }
        return afterPre;
    }

    private int[] removeElementFromPost(int element, int[] post){
        int [] afterPost = new int[post.length - 1];
        int i = 0;
        for(int e: post)
        {
            if(e != element)
            {
                afterPost[i++] = e;
            }
        }
        return afterPost;
    }*/

    public BSTNode constructFromPrePost(int[] pre, int[] post) {
        int lengthOfPre = pre.length;
        if (lengthOfPre == 0) return null;
        BSTNode<Integer> n = new BSTNode<>(pre[0]);
        if (lengthOfPre == 1) {
            return n;
        }

        int indexInPost = 0;
        for (int i = 0; i < post.length; i++) {
            if (post[i] == pre[1]) {
                indexInPost = i;
                break;
            }
        }
        int L = indexInPost + 1;

        n.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
        n.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, pre.length), Arrays.copyOfRange(post, L, post.length - 1));
        return n;
    }
}
