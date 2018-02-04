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
                    NonStartDetails nonStartDetails = firstNonStartChar(p, pi);

                    if(nonStartDetails.nonStarChar == '?') {
                        pi = nonStartDetails.index;
                    } else if (nonStartDetails.nonStarChar != ' ') {
                        String subStringFromS = s.substring(si, s.length() - 1);
                        int index = starFound(subStringFromS, nonStartDetails.nonStarChar);

                        if (index == -1) {
                            return false;
                        } else {
                            si = index;
                            pi = nonStartDetails.index;
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
