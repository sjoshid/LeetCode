package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-72/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> listOfPerms = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                char upper = Character.toUpperCase(c);
                char lower = Character.toLowerCase(c);
                List<String> perms = letterCasePermutation(S.substring(i + 1));

                for (String perm : perms) {
                    listOfPerms.add(S.substring(0, i) + upper + perm);
                    listOfPerms.add(S.substring(0, i) + lower + perm);
                }
                break;
            }
        }
        if (listOfPerms.isEmpty()) {
            listOfPerms.add(S);
        }
        return listOfPerms;
    }
}
