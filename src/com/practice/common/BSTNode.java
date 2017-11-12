package com.practice.common;

public class BSTNode<V> {
    private BSTNode left;
    private BSTNode right;
    private V value;

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
