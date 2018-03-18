package com.practice.test;

import com.practice.AllPathsFromSourceToTarget;
import com.sun.javafx.image.IntPixelGetter;
import junit.framework.TestCase;

import java.util.List;

public class TestAllPathsFromSourceToTarget extends TestCase {

    AllPathsFromSourceToTarget m;

    @Override
    public void setUp () {
        m = new AllPathsFromSourceToTarget();
    }

    public void testCase1() {
        int [] i1 = new int[]{1,2};
        int [] i2 = new int[]{3};
        int [] i3 = new int[]{3};
        int [] i4 = new int[]{};

        int [][] i = new int[4][];
        i[0] = i1;
        i[1] = i2;
        i[2] = i3;
        i[3] = i4;

       // m.allPathsSourceTarget(i);
    }

    public void testCase2() {
        int [] i1 = new int[]{4,3,1};
        int [] i2 = new int[]{3,2,4};
        int [] i3 = new int[]{3};
        int [] i4 = new int[]{4};
        int [] i5 = new int[]{};

        int [][] i = new int[5][];
        i[0] = i1;
        i[1] = i2;
        i[2] = i3;
        i[3] = i4;
        i[4] = i5;

        m.allPathsSourceTarget(i);
    }

    @Override
    public void tearDown () {
        m = null;
    }
}

