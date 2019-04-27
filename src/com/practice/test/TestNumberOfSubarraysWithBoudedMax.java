package com.practice.test;

import com.practice.NumberOfSubarraysWithBoudedMax;
import junit.framework.TestCase;

public class TestNumberOfSubarraysWithBoudedMax extends TestCase {

    NumberOfSubarraysWithBoudedMax m;

    @Override
    public void setUp() {
        m = new NumberOfSubarraysWithBoudedMax();
    }

    public void testCase1() {
        int[] A = new int[]{2, 1, 4, 3};
        int L = 2;
        int R = 3;
        int count = m.numSubarrayBoundedMax(A, L, R);
        assertEquals(3, count);
    }

    @Override
    public void tearDown() {
        m = null;
    }
}
