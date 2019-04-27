package com.practice;

/*
    https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        LongestPalindrome lp = new LongestPalindrome();
        lp.longestPalindrome("abb");
        lp.longestPalindrome("abcdcba");
        lp.longestPalindrome("acbcmjhjmc");
        lp.longestPalindrome("abcdcbajjkl");
        lp.longestPalindrome("jkwerabcdcba");
        lp.longestPalindrome("jkweabccba");
        lp.longestPalindrome("cbbd");
        lp.longestPalindrome("babad");

    }

    public String longestPalindrome(String s) {

        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        if (s.length() == 2 && (s.charAt(0) == s.charAt(1))) {
            return s;
        }
        int j = 1;
        while (j < s.length() && s.charAt(0) == s.charAt(j)) {
            j++;
        }

        String longestPalindrome = s.substring(0, j);
        //if(j > 1) longestPalindrome = s.substring(0, j);

        for (int i = 1; i < s.length() - 1; i++) {
            String currentLongest = null;

            char c = s.charAt(i);
            int inc = i + 1;
            int dec = i - 1;
            String evenLongest = "";
            String oddLongest = "";

            if (c == s.charAt(inc)) {
                evenLongest = checkPalindrome(s, i, false);
            }
            if (s.charAt(inc) == s.charAt(dec)) {
                oddLongest = checkPalindrome(s, i, true);
            }

            if (evenLongest.length() > oddLongest.length()) {
                currentLongest = evenLongest;
            } else {
                if (oddLongest.length() > evenLongest.length()) {
                    currentLongest = oddLongest;
                }
            }

            if (!evenLongest.isEmpty() && evenLongest.length() == oddLongest.length()) {
                currentLongest = oddLongest;
            }

            if (currentLongest != null && currentLongest.length() > longestPalindrome.length()) {
                longestPalindrome = currentLongest;
                if (longestPalindrome.length() == s.length())
                    return longestPalindrome;
            }
        }
        return longestPalindrome;
    }

    private String checkPalindrome(String s, int index, boolean isOdd) {

        int inc = index + 1;
        if (!isOdd) {
            inc = index + 2;
        }
        int dec = index - 1;
        while (inc < s.length() && dec >= 0 && s.charAt(inc) == s.charAt(dec)) {
            inc++;
            dec--;
        }

        return s.substring(dec + 1, inc);
    }
}
