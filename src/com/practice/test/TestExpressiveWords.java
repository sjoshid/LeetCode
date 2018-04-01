package com.practice.test;

import com.practice.ExpressiveWords;
import junit.framework.TestCase;

public class TestExpressiveWords extends TestCase {

        ExpressiveWords m;

        @Override
        public void setUp () {
        m = new ExpressiveWords();
    }

    public void testCase1() {
        m.buildExtendedLib("aaabbbaa");
        int result = m.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
        assertEquals(1, result);
    }

    public void testCase2() {
        m.buildExtendedLib("abc");
        int result = m.expressiveWords("hhhellllloo", new String[]{"helo", "hi", "heo"});
        assertEquals(0 , result);
    }

    public void testCase3() {
        
        int result = m.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
        assertEquals(1, result);
    }

    public void testCase5() {
        
        int result = m.expressiveWords("hheeellooo", new String[]{"hello", "hi", "helo"});
        assertEquals(0, result);
    }

    public void testCase6() {
        
        int result = m.expressiveWords("heeellooo", new String[]{"hello", "hello", "helo"});
        assertEquals(2, result);
    }

    public void testCase7() {
        
        int result = m.expressiveWords("a", new String[]{"ahhh", "hello", "helo"});
        assertEquals(0, result);
    }

    public void testCase8() {

        int result = m.expressiveWords("aaaa", new String[]{"aaaaaa", "hello", "helo"});
        assertEquals(0, result);
    }

    public void testCase9() {

        int result = m.expressiveWords("abbbdddd", new String[]{"aaaabd"});
        assertEquals(0, result);
    }



    public void testCase10() {

        int result = m.expressiveWords("ggkyyyyffffbbhddddrxxsiixccqqqqkmmmiiiiiivvvyyuuujccuuuhhhhwssssnnttoyuuuussggttttfeeeebbbbeedddddqq", new String[]{"ggkyyyfffbbhdddrxxsiixccqqkmmmiiiiivvyyuuujccuuuhhwssnnttoyussggtttfeeebbeeddddqq"});
        assertEquals(1, result);
    }

    public void testCase4() {
        m.buildExtendedLib("aabbcc");
        int result = m.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
        assertEquals(1, result);
    }

    @Override
    public void tearDown () {
        m = null;
    }
}
