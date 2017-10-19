package com.practice;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {

    }


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> m = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            String original = strs[i];
            String sorted = sortString(original);

            if(m.containsKey(sorted)) {
                List<String> existing = m.get(sorted);
                existing.add(original);
            } else {
                List<String> initial = new ArrayList<String>();
                initial.add(original);
                m.put(sorted, initial);
            }
        }

        List<List<String>> output = new ArrayList<List<String>>();

        for (Map.Entry<String, List<String>> entry: m.entrySet()) {

            List<String> mainList = entry.getValue();
            output.add(mainList);

        }

        return output;
    }

    private String sortString(String s) {
        char tempArray[] = s.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        return new String(tempArray);
    }
}
