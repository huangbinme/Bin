package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_12 {

    static List<String[]> list = new ArrayList<>();

    static {
        list.add(new String[]{"1", "I"});
        list.add(new String[]{"4", "IV"});
        list.add(new String[]{"5", "V"});
        list.add(new String[]{"9", "IX"});
        list.add(new String[]{"10", "X"});
        list.add(new String[]{"40", "XL"});
        list.add(new String[]{"50", "L"});
        list.add(new String[]{"90", "XC"});
        list.add(new String[]{"100", "C"});
        list.add(new String[]{"400", "CD"});
        list.add(new String[]{"500", "D"});
        list.add(new String[]{"900", "CM"});
        list.add(new String[]{"1000", "M"});
    }

    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                String[] strings = list.get(i);
                int j = Integer.parseInt(strings[0]);
                if (num >= j) {
                    ans.append(strings[1]);
                    num -= j;
                    break;
                }
            }
        }
        return ans.toString();
    }
}
