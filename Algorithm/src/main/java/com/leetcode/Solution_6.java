package com.leetcode;

public class Solution_6 {
    public String convert(String s, int numRows) {
        //PAYPALISHIRING
        int max = 2 * (numRows - 1);
        int min = 2;
        int dis = max;
        boolean down = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int base = i;
            while (s.length() > base) {
                sb.append(s.charAt(base));
                base += dis;
            }
            if (down && dis != min){
                dis -= 2;
            }else if(!down && dis != max){
                dis += 2;
            }else if(down && dis == min){
                down = false;
                dis += 2;
            }else {
                down = true;
                dis -= 2;
            }
        }
        return sb.toString();
    }
}
