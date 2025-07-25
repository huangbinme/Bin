package com.interview.amazon;

public class Solution_4 {
    public static String missingDigits(String config, int x, int y) {
        StringBuilder ans = new StringBuilder("0");
        for (int i = 0; i < config.length(); i++) {
            String s = get(x, y, ans.charAt(ans.length() - 1) - '0', config.charAt(i) - '0');
            if (s.isEmpty()) return "NO";
            ans.append(s);
        }
        ans.deleteCharAt(0);
        return ans.toString();
    }

    public static String get(int x, int y, int from, int to) {
        int xCount = 10000, yCount = 10000;
        //num < 10, z < 10
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if ((from + x * i + y * j) % 10 == to && (i + j < xCount + yCount)) {
                    xCount = i;
                    yCount = j;
                }
            }
        }
        if (xCount == 10000) return "";
        StringBuilder ans = new StringBuilder(from);
        ans.append(from);
        int sum = from;
        while (xCount != 0 || yCount != 0) {
            if (xCount == 0) {
                for (int i = 0; i < yCount; i++) {
                    sum += y;
                    ans.append(sum % 10);
                }
                break;
            } else if (yCount == 0) {
                for (int i = 0; i < xCount; i++) {
                    sum += x;
                    ans.append(sum % 10);
                }
                break;
            } else {
                int modX = (sum + x) % 10, modY = (sum + y) % 10;
                if (modX <= modY) {
                    ans.append(modX);
                    sum += x;
                    xCount--;
                } else {
                    ans.append(modY);
                    sum += y;
                    yCount--;
                }
            }
        }
        ans.deleteCharAt(0);
        return ans.toString();
    }
}
