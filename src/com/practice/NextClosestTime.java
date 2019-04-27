package com.practice;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        Set<Integer> uniq = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':') {
                Integer t = Integer.parseInt(time.substring(i, i + 1));
                uniq.add(t);
            }
        }

        String[] splitTime = time.split(":");
        Integer min = Integer.parseInt(splitTime[1]);
        Integer hrs = Integer.parseInt(splitTime[0]);

        int cm = 0;

        while (true) {
            int l = Integer.parseInt(time.substring(time.length() - 1));
            int sl = Integer.parseInt(time.substring(time.length() - 2, time.length() - 1));
            int tl = Integer.parseInt(time.substring(time.length() - 3, time.length() - 2));
            int fl = Integer.parseInt(time.substring(time.length() - 4, time.length() - 3));

            l += 1;
            if (l > 9) {
                l = 0;
                sl += 1;
            }

            if (sl == 6 && l == 0) {
                l = 0;
                sl = 0;
                tl += 1;
            }

            if (tl > 9) {
                tl = 0;
                fl += 1;
            }

        }

    }
}
