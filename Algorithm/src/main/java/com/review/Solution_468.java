package com.review;

public class Solution_468 {
    public String validIPAddress(String queryIP) {
        boolean isIpv4 = isIpv4(queryIP);
        if (isIpv4) return "IPv4";
        boolean isIpv6 = isIpv6(queryIP);
        if (isIpv6) return "IPv6";
        return "Neither";
    }

    private boolean isIpv4(String queryIP) {
        if (queryIP == null || queryIP.length() == 0) return false;
        if (queryIP.charAt(queryIP.length() - 1) == '.') return false;
        String[] ips = queryIP.split("\\.");
        if (ips.length != 4) return false;
        for (int i = 0; i < ips.length; i++) {
            String ip = ips[i];
            if (ip.length() > 1 && ip.charAt(0) == '0') return false;
            if (ip.length() > 3 || ip.length() == 0) return false;
            for (int j = 0; j < ip.length(); j++) {
                if (!Character.isDigit(ip.charAt(j))) return false;
            }
            int n = Integer.parseInt(ip);
            if (!(n >= 0 && n <= 255)) return false;
        }
        return true;
    }

    private boolean isIpv6(String queryIP) {
        if (queryIP == null || queryIP.length() == 0) return false;
        if (queryIP.charAt(queryIP.length() - 1) == ':') return false;
        String[] ips = queryIP.split(":");
        if (ips.length != 8) return false;
        for (int i = 0; i < ips.length; i++) {
            String ip = ips[i];
            if (ip.length() > 4 || ip.length() == 0) return false;
            for (int j = 0; j < ip.length(); j++) {
                if (!(Character.isDigit(ip.charAt(j)) || isLetter(ip.charAt(j)))) return false;
            }
        }
        return true;
    }

    private boolean isLetter(char c) {
        return (c - 'a' >= 0 && c - 'a' < 6) || (c - 'A' >= 0 && c - 'A' < 6);
    }
}
