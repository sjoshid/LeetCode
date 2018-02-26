package com.practice.test;

import com.practice.WildcardMatching;
import junit.framework.TestCase;

public class WildcardMatchingTest extends TestCase {

    WildcardMatching m;

    @Override
    public void setUp () {
        m = new WildcardMatching();
    }

    public void testCase1() {
        assertFalse(m.isMatch("zacabz", ""));
        assertFalse(m.isMatch("zacabz", "*a?b*"));
        assertTrue(m.isMatch("a", "a*"));
        assertFalse(m.isMatch("a", "a*?"));
        assertTrue(m.isMatch("", "*"));
        assertFalse(m.isMatch("", "*?"));
        assertTrue(m.isMatch("hi", "*?"));
        assertTrue(m.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        assertTrue(m.isMatch("aaaa","*a"));
        assertFalse(m.isMatch("aa","a?b"));
        assertFalse(m.isMatch("aa","ab"));
        assertTrue(m.isMatch("aa","a***"));

        assertFalse(m.isMatch("aa","a"));
        assertTrue(m.isMatch("aa","aa"));
        assertFalse(m.isMatch("aaa","aa"));
        assertTrue(m.isMatch("aa","*"));
        assertTrue(m.isMatch("ab","?*"));
        assertFalse(m.isMatch("aab","c*a*b"));

        assertTrue(m.isMatch("aab", "a*?*"));
        assertTrue(m.isMatch("ab", "?*******?"));
        assertFalse(m.isMatch("abc", "?*******?"));

    }

    @Override
    public void tearDown () {
        m = null;
    }
}
