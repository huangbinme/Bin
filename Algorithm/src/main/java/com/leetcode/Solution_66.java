package com.leetcode;

public class Solution_66 {
    public int[] plusOne(int[] digits) {
        int[] plusDigits = plus(digits);
        return judgeAndResize(plusDigits);
    }

    private int[] judgeAndResize(int[] plusDigits) {
        int[] newArray;
        if (plusDigits[0] >= 10) {
            newArray = new int[plusDigits.length + 1];
            System.arraycopy(plusDigits, 0, newArray, 1, plusDigits.length);
            newArray[0] = 1;
            newArray[1] -= 10;
        } else {
            newArray = plusDigits;
        }
        return newArray;
    }

    private int[] plus(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i] -= 10;
                digits[i - 1] += 1;
            } else {
                break;
            }
        }
        return digits;
    }
}
