package com.practice;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        /*l.lengthOfLongestSubstring("vfbb");
        l.lengthOfLongestSubstring("gvgd");
        l.lengthOfLongestSubstring("bbbb");
        l.lengthOfLongestSubstring("qweru");*/
        l.lengthOfLongestSubstring("abcdebbbiopklwsz");
    }

    public int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;
        List<Character> l = new ArrayList<>();

        l.add(s.charAt(0));
        int max = 1;

        for (int i = 1; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (l.contains(c)) {
                if (l.size() > max) max = l.size();

                List<Character> newList = new ArrayList<>();
                int indexOfC = l.indexOf(c);

                if (indexOfC < l.size() - 1) {
                    newList = new ArrayList<>(l.subList(indexOfC + 1, l.size()));
                }

                newList.add(c);
                l = newList;
            } else {
                l.add(c);
            }
        }

        if (l.size() > max) max = l.size();
        return max;
    }
}
