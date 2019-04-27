package com.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<String, Integer> m = new LinkedHashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);

            if (m.containsKey(c)) {
                int v = m.get(c);
                v++;
                m.put(c, v);
            } else {
                m.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);

            if (m.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
