package com.practice;

public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching wcm = new WildcardMatching();
        System.out.println(wcm.isMatch("aa","a?b"));
        System.out.println(wcm.isMatch("aa","ab"));
        System.out.println(wcm.isMatch("aa","a*"));
        System.out.println(wcm.isMatch("aa","*a"));

        System.out.println(wcm.isMatch("aa","a"));
        System.out.println(wcm.isMatch("aa","aa"));
        System.out.println(wcm.isMatch("aaa","aa"));
        System.out.println(wcm.isMatch("aa", "*"));
        System.out.println(wcm.isMatch("aa", "a*"));
        System.out.println(wcm.isMatch("ab", "?*"));
        System.out.println(wcm.isMatch("aab", "c*a*b"));

        System.out.println("========");
        System.out.println(wcm.isMatch("aab", "a*?*"));

    }

    public boolean isMatch(String s, String p) {

        int si = 0;
        int pi = 0;

        while(si < s.length() && pi < p.length()){
            char sc = s.charAt(si);
            char pc = p.charAt(pi);

            switch (pc) {
                case '*':
                    NonStartDetails nonStartDetails = firstNonStartChar(p, pi);

                    if(nonStartDetails.nonStarChar == '?') {
                        si = si + 1;
                        pi = nonStartDetails.index;
                    } else if (nonStartDetails.nonStarChar != ' ') {
                        String subStringFromS = s.substring(si, s.length() - 1);
                        int index = starFound(subStringFromS, nonStartDetails.nonStarChar);

                        if (index == -1) {
                            return false;
                        } else {
                            si = index + 1;
                            pi = nonStartDetails.index;
                        }
                    } else {
                        si = s.length() - 1;
                        pi = p.length() - 1;
                    }
                    break;
                case '?':
                    //do nothing.
                    break;
                default:
                    if (!charFound(sc, pc)) return false;
            }

            si++;
            pi++;
        }

        if((si == s.length() && pi < p.length()) || (si < s.length() && pi == p.length())) {
            return false;
        }
        return true;
    }

    private boolean charFound (char s, char p) {
        return s == p;
    }

    private int starFound (String subStringFromS, char charFromP) {
        return subStringFromS.indexOf(charFromP);
    }

    private NonStartDetails firstNonStartChar(String s, int startIndex) {
        for (int i = startIndex; i < s.length(); i++) {
            if(s.charAt(i) != '*') {
                return new NonStartDetails(i, s.charAt(i));
            }
        }
        return new NonStartDetails(-1, ' ');
    }
}

class NonStartDetails {
    int index;
    char nonStarChar;

    NonStartDetails(int index, char nonStarChar){
        this.index = index;
        this.nonStarChar = nonStarChar;
    }
}
