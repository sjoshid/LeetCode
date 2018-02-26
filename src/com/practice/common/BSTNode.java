package com.practice.common;

public class BSTNode<V> {
    public BSTNode left;
    public BSTNode right;
    public V value;

    public BSTNode(V value){
        this.value = value;
    }

    public V getValue(){
        return value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setLeft(BSTNode leftNode){
        this.left = leftNode;
    }

    public void setRight(BSTNode rightNode){
        this.right = rightNode;
    }
}
