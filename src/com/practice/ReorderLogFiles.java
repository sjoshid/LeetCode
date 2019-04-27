package com.practice;

import java.util.*;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Map<String, List<String>> m = new TreeMap<>();
        List<String> numbers = new LinkedList<>();

        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            char c = log.charAt(log.length() - 1);

            if(Character.isDigit(c)){
                numbers.add(log);
            } else {
                String [] tokens = log.split(" ", 2);
                String ident = tokens[0];
                String other = tokens[1];

                if(m.containsKey(other)) {
                    List<String> existing = m.get(other);
                    existing.add(ident);
                    Collections.sort(existing);
                } else {
                    List<String> newList = new ArrayList<>();
                    newList.add(ident);
                    m.put(other, newList);
                }
            }
        }

        String [] ans = new String[logs.length];
        int i = 0;
        for (Map.Entry<String, List<String>> s: m.entrySet()) {
            List<String> l = s.getValue();
            String v = s.getKey();
            if (l.size() > 1) {
                for (String o: l) {
                    String og = o + " " + v;
                    ans[i++] = og;
                }
            } else {
                String og = l.get(0) + " " + v;
                ans[i++] = og;
            }
        }

        for (String num: numbers
             ) {
            ans[i++] = num;
        }

        return ans;
    }

    public static void main(String[] args) {
        ReorderLogFiles r = new ReorderLogFiles();
        r.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","a1 act car","a8 act zoo"});
    }
}
