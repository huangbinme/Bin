package com.leetcode;

public class Solution_393 {
    public boolean validUtf8(int[] data) {
        int p = 0;
        while (p < data.length) {
            if (isOne(data, p)) {
                p++;
            } else if (isTwo(data, p)) {
                p += 2;
            } else if (isThree(data, p)) {
                p += 3;
            } else if (isFour(data, p)) {
                p += 4;
            } else {
                return false;
            }
        }
        return data.length == p;
    }

    public boolean isOne(int[] data, int l) {
        return l < data.length && isZero(data[l], 7);
    }

    public boolean isTwo(int[] data, int l) {
        return l + 1 < data.length && !isZero(data[l], 7) && !isZero(data[l], 6) && isZero(data[l], 5) && startWithOneZero(data[l + 1]);
    }

    public boolean isThree(int[] data, int l) {
        return l + 2 < data.length && !isZero(data[l], 7) && !isZero(data[l], 6) && !isZero(data[l], 5) && isZero(data[l], 4) && startWithOneZero(data[l + 1]) && startWithOneZero(data[l + 2]);
    }

    public boolean isFour(int[] data, int l) {
        return l + 3 < data.length && !isZero(data[l], 7) && !isZero(data[l], 6) && !isZero(data[l], 5) && !isZero(data[l], 4) && isZero(data[l], 3) && startWithOneZero(data[l + 1]) && startWithOneZero(data[l + 2]) && startWithOneZero(data[l + 3]);
    }

    public boolean startWithOneZero(int data) {
        return !isZero(data, 7) && isZero(data, 6);
    }

    public boolean isZero(int data, int l) {
        return (1 << l & data) == 0;
    }
}
