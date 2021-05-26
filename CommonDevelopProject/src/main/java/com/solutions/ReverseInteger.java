package com.solutions;

public class ReverseInteger {
    public int reverse(int x) {
        boolean ifMinus = false;
        if (x < 0) {
            x = -x;
            ifMinus = true;
        }
        StringBuilder str = new StringBuilder(Integer.toString(x));
        int result = Integer.valueOf(str.reverse().toString());

        return ifMinus ? -result : result;
    }
}
