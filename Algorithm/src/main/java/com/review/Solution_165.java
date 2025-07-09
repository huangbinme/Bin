package com.review;

public class Solution_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1Index = 0, v2Index = 0;
        while (v1Index < v1.length || v2Index < v2.length) {
            int subV1 = v1Index < v1.length ? Integer.parseInt(v1[v1Index]) : 0;
            int subV2 = v2Index < v2.length ? Integer.parseInt(v2[v2Index]) : 0;
            if (subV1 != subV2) return subV1 > subV2 ? 1 : -1;
            v1Index++;
            v2Index++;
        }
        return 0;
    }
}
