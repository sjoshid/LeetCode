package com.practice.common;

public class BSTNodeWithParent<V> {
    private BSTNodeWithParent parent;
    private V value;

    public BSTNodeWithParent(V value) {
        this.value = value;
    }

    public BSTNodeWithParent getParent() {
        return parent;
    }

    public void setParent(BSTNodeWithParent parent) {
        this.parent = parent;
    }

    public V getValue() {
        return value;
    }
}

