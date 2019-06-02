package com.practice;

public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String S) {
        int longest = 0;
        String cs = "";
        int start = 0;
        for (int i = 0; i < S.length(); i++) {

            char c = S.charAt(i);
            cs = cs.concat("" + c);

            if (S.indexOf(cs) != S.lastIndexOf(cs)) {
                longest = Math.max(cs.length(), longest);
            } else {
                cs = "";
                i = ++start;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestRepeatingSubstring j = new LongestRepeatingSubstring();
        j.longestRepeatingSubstring("abbbabbbaaaabbaaaaaabbbaabbbbbbbbbaaaabbabbaba");
        //j.longestRepeatingSubstring("aabcaabdaab");
    }
}
