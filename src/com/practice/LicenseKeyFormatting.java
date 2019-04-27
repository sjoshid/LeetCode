package com.practice;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        if (S.length() < K) {
            return S;
        }
        int og = S.length();
        int r = og % K;

        String res = "";

        if (r == 0) {
            return append(S, K).toUpperCase();
        } else {

            for (int i = 0; i < r; i++) {
                res = res.concat("" + S.charAt(i));
            }

            String last = append(S.substring(r), K);
            return res.concat("-").concat(last).toUpperCase();
        }
    }

    String append(String og, int k) {

        if (og.length() > k) {
            int times = og.length() / k;
            String res = "";
            int ind = 0;
            for (int i = 0; i < times; i++) {
                String sub = og.substring(ind, ind + k);
                res = res.concat(sub).concat("-");

                ind += k;
            }
            return res.substring(0, res.length() - 1);
        } else {
            return og;
        }
    }

    public static void main(String[] args) {
        LicenseKeyFormatting l = new LicenseKeyFormatting();
        System.out.println(l.licenseKeyFormatting("2", 2));
    }
}
