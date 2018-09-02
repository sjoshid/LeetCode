package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-78/problems/expressive-words/
 */
public class ExpressiveWords {

    public int expressiveWords(String S, String[] words) {
        List<Word> extendedLib = buildExtendedLib(S);
        int result = 0;

        for (String word : words) {
            if (isExpressiveWord(word, extendedLib)) {
                result++;
            }
        }

        return result;
    }

    private boolean isExpressiveWord(String word, List<Word> extendedLib) {

        char[] chars = word.toCharArray();
        int i = 0;
        for (Word w : extendedLib) {
            String wc = w.s;
            boolean extended = w.extended;

            if (extended) {
                int j = i + 1;
                while (j < chars.length) {
                    if (chars[i] == chars[j]) {
                        j++;
                    } else {
                        break;
                    }
                }
                String repeatingLetters = word.substring(i, j);
                if (repeatingLetters.length() <= wc.length()) {
                    i = j;
                } else {
                    return false;
                }
            } else {
                String toCheck = word.substring(i, Math.min(i + w.length, word.length()));
                if (!toCheck.equals(wc)) {
                    return false;
                }
                i = i + w.length;
            }
        }

        return i == word.length();
    }

    public List<Word> buildExtendedLib(String s) {
        List<Word> extendedLib = new ArrayList<>();

        int i = 1;
        char prev = s.charAt(0);
        int count = 0;
        String currentExtension = String.valueOf(prev);
        while (i < s.length()) {
            char curr = s.charAt(i);

            if (curr == prev) {
                count++;
                currentExtension = currentExtension.concat(String.valueOf(s.charAt(i)));
            } else {
                if (currentExtension.length() > 2) {
                    Word newWord = new Word();
                    newWord.length = currentExtension.length();
                    newWord.extended = true;
                    newWord.s = currentExtension;
                    extendedLib.add(newWord);
                } else {
                    Word newWord = new Word();
                    newWord.length = currentExtension.length();
                    newWord.extended = false;
                    newWord.s = currentExtension;
                    extendedLib.add(newWord);
                }
                prev = s.charAt(i);
                currentExtension = String.valueOf(prev);
            }
            i++;
        }

        Word newWord = new Word();
        newWord.length = currentExtension.length();
        newWord.extended = currentExtension.length() > 2;
        newWord.s = currentExtension;
        extendedLib.add(newWord);
        return extendedLib;
    }
}

class Word {
    String s;
    boolean extended;
    int length;
}
