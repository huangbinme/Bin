package com.leetcode;

public class Solution_2299 {
    public boolean strongPasswordCheckerII(String password) {
        String specialStr = "!@#$%^&*()-+";
        boolean lower = false, upper = false, number = false, special = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c - 'a' >= 0 && c - 'a' < 26) {
                lower = true;
            } else if (c - 'A' >= 0 && c - 'A' < 26) {
                upper = true;
            } else if (c - '0' >= 0 && c - '0' <= 10) {
                number = true;
            } else if (specialStr.contains(String.valueOf(c))) {
                special = true;
            }
            if (i != password.length() - 1 && c == password.charAt(i + 1)) return false;
        }
        return lower && upper && number && special && password.length() >= 8;
    }
}
