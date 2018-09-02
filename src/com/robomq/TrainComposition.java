package com.robomq;

public class TrainComposition {

    Wagon dummy = null;
    Wagon l;
    Wagon r;

    public void attachWagonFromLeft(int wagonId) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        Wagon given = new Wagon(wagonId);
        if (dummy == null) {
            l = given;
            r = given;
            dummy = given;
        } else {
            l.pre = given;
            given.next = l;
            l = given;
        }
    }

    public void attachWagonFromRight(int wagonId) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        Wagon given = new Wagon(wagonId);
        if (dummy == null) {
            l = given;
            r = given;
            dummy = given;
        } else {
            r.next = given;
            given.pre = r;
            r = given;
        }
    }

    public int detachWagonFromLeft() {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        int v = l.value;
        l = l.next;
        if (l != null) l.pre = null;
        return v;
    }

    public int detachWagonFromRight() {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        int v = r.value;
        r = r.pre;
        if (r != null) r.next = null;
        return v;
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}

class Wagon {
    Wagon pre;
    Wagon next;
    int value;

    Wagon(int value) {
        this.value = value;
    }

    Wagon() {
    }
}
