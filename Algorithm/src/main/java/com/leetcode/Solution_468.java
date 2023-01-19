package com.leetcode;

public class Solution_468 {
    public String validIPAddress(String queryIP) {
        if (isIpv4(queryIP)) return "IPv4";
        if (isIpv6(queryIP)) return "IPv6";
        return "Neither";
    }

    private boolean isIpv6(String queryIP) {
        if (queryIP == null || queryIP.length() == 0 || queryIP.charAt(queryIP.length() - 1) == ':') return false;
        String[] split = queryIP.split(":");
        if (split.length != 8) return false;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (!(s.length() >= 1 && s.length() <= 4)) return false;
            for (int j = 0; j < s.length(); j++) {
                if (!((s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9) || (s.charAt(j) - 'a' >= 0 && s.charAt(j) - 'a' < 6) || (s.charAt(j) - 'A' >= 0 && s.charAt(j) - 'A' < 6)))
                    return false;
            }
        }
        return true;
    }

    private boolean isIpv4(String queryIP) {
        if (queryIP == null || queryIP.length() == 0 || queryIP.charAt(queryIP.length() - 1) == '.') return false;
        String[] split = queryIP.split("\\.");
        if (split.length != 4) return false;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.length() == 0 || s.length() > 3) return false;
            for (int j = 0; j < s.length(); j++) {
                if (!(s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9)) return false;
            }
            if (s.charAt(0) == '0' && s.length() > 1) return false;
            int k = Integer.parseInt(s);
            if (!(k >= 0 && k <= 255)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('G' - 'A');
    }
}
