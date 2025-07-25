package com.algorithm;

public class Base62 {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE62_LENGTH = BASE62.length();

    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int index = (int) (num % BASE62_LENGTH);
            char c = BASE62.charAt(index);
            sb.insert(0, c);
            num /= BASE62_LENGTH;
        }
        return sb.toString();
    }

    public static int decode(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans = ans * BASE62_LENGTH + BASE62.indexOf(str.charAt(i));
        }
        return ans;
    }
}
