package com.practice;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        l.lengthOfLongestSubstring("vfbb");
    }

    public int lengthOfLongestSubstring(String s) {
        LinkedHashSet<Character> chars = new LinkedHashSet<>();

        if(s.isEmpty()) return 0;
        chars.add(s.charAt(0));
        int maxSize = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!chars.add(c)){
                int currentSize = chars.size();

                if (currentSize > maxSize) {
                    maxSize = currentSize;
                }

                Object [] charArray = chars.toArray();
                if((char)charArray[0] == c){
                    chars.remove(c);
                    chars.add(c);
                } else {

                    chars = new LinkedHashSet<Character>();
                    chars.add(c);
                }
            } else {
                int currentSize = chars.size();

                if(currentSize > maxSize){
                    maxSize = currentSize;
                }
            }
        }

        return maxSize;
    }
}
