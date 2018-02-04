package com.practice;

public class WildcardMatching {

    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {

        int si = 0;
        int pi = 0;

        while(si < s.length() && pi < p.length()){
            char sc = s.charAt(si);
            char pc = p.charAt(pi);

            switch (pc) {
                case '*':
                    char nonStartChar = firstNonStartChar(p, pi);

                    if(nonStartChar == '?') {
                        pi = p.indexOf('?', pi);
                    } else if (nonStartChar != ' ') {
                        String subStringFromS = s.substring(si, s.length() - 1);
                        int index = starFound(subStringFromS, nonStartChar);

                        if (index == -1) {
                            return false;
                        } else {
                            si = index;
                        }
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
        return true;
    }

    private boolean charFound (char s, char p) {
        return s == p;
    }

    private int starFound (String subStringFromS, char charFromP) {
        return subStringFromS.indexOf(charFromP);
    }

    private char firstNonStartChar(String s, int startIndex) {
        for (int i = startIndex; i < s.length(); i++) {
            if(s.charAt(i) != '*') {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
