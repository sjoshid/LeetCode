package com.practice.test;

import com.practice.LetterCasePermutation;
import junit.framework.TestCase;

import java.util.List;

public class TestLetterCasePermutation extends TestCase {

    LetterCasePermutation m;

    @Override
    public void setUp() {
        m = new LetterCasePermutation();
    }

    public void testCase1() {
        List<String> perms = m.letterCasePermutation("a1b1");
        assertTrue(perms.contains("a1b1"));
        assertTrue(perms.contains("A1b1"));
        assertTrue(perms.contains("a1B1"));
        assertTrue(perms.contains("A1B1"));

        assertTrue(perms.size() == 4);
    }

    public void testCase2() {
        List<String> perms = m.letterCasePermutation("a");
        assertTrue(perms.contains("a"));
        assertTrue(perms.contains("A"));

        assertTrue(perms.size() == 2);
    }

    public void testCase3() {
        List<String> perms = m.letterCasePermutation("ab");
        assertTrue(perms.contains("ab"));
        assertTrue(perms.contains("aB"));
        assertTrue(perms.contains("Ab"));
        assertTrue(perms.contains("AB"));

        assertTrue(perms.size() == 4);
    }

    public void testCase4() {
        List<String> perms = m.letterCasePermutation("123");
        assertTrue(perms.contains("123"));

        assertTrue(perms.size() == 1);
    }

    public void testCase5() {
        List<String> perms = m.letterCasePermutation("3z4");
        assertTrue(perms.contains("3z4"));
        assertTrue(perms.contains("3Z4"));

        assertTrue(perms.size() == 2);
    }

    @Override
    public void tearDown() {
        m = null;
    }
}
