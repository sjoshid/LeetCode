package com.practice;

public class Factorial {

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.getFactorial(6));
    }

    public int getFactorial(int i) {

        if (i == 1)
            return 1;

        return i * getFactorial(i - 1);
    }

    public int getFactorial1(int i) {
        int cfact = i--;

        while (i > 0) {
            cfact = cfact * i;
            i--;
        }
        System.out.println(cfact);
        return cfact;
    }
}
