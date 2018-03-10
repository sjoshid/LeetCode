package com.practice.test;

import com.practice.ValidateTicTacToe;
import junit.framework.TestCase;

public class TestValidateTicTacToe extends TestCase {

    ValidateTicTacToe m;

    @Override
    public void setUp () {
        m = new ValidateTicTacToe();
    }

    public void testCase1() {
        String [] board = new String[]{"XXX", "   ", "OOO"};
        assertFalse(m.validTicTacToe(board));
    }

    public void testCase2() {
        String [] board = new String[]{"O  ", "   ", "   "};
        assertFalse(m.validTicTacToe(board));
    }

    public void testCase3() {
        String [] board = new String[]{"XOX", " X ", "   "};
        assertFalse(m.validTicTacToe(board));
    }

    public void testCase4() {
        String [] board = new String[]{"XOX", "O O", "XOX"};
        assertTrue(m.validTicTacToe(board));
    }

    public void testCase5() {
        String [] board = new String[]{"XOX", "OXO", "XOX"};
        assertTrue(m.validTicTacToe(board));
    }

    public void testCase6() {
        String [] board = new String[]{"XXX","XOO","OO "};
        assertFalse(m.validTicTacToe(board));
    }

    public void testCase7() {
        String [] board = new String[]{"OOO","OXX","X  "};
        assertFalse(m.validTicTacToe(board));
    }

    @Override
    public void tearDown () {
        m = null;
    }
}
