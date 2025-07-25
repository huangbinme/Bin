package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP_Algorithm {
    public List<Integer> contains(String s1, String s2) {
        List<Integer> nonMatched = Arrays.asList(-1);
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() < s2.length())
            return nonMatched;//判空，我们假设s1和s2的长度都必须大于或者等于1
        int j = 0;
        int[] lpsArray = getLpsArray(s2);//求出lps数组，也就是当i和j所指向的字符不相等时，s2的指针j的回退位置
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;//如果char[i]和char[j]，直接向右移动j指针即可
            } else {
                while (j > 0 && s1.charAt(i) != s2.charAt(j)) j = lpsArray[j];//如果字符不相等，按照lsp数组的值回退j指针
                if (s1.charAt(i) == s2.charAt(j)) j++;//回退完毕后要判断一下字符是否相等，如果相等还要额外移动一次j指针，这里很重要，容易漏！
            }
            if (j == lpsArray.length - 1) {//如果j等于lpsArray.length - 1那么意味着s2已经被遍历完，s2完全出现在s1中，这是一个我们想要的结果
                ans.add(i - s2.length() + 1);
                j = lpsArray[j];//回退一次j指针，继续遍历，这里很重要，容易漏！
            }
        }
        return ans.isEmpty() ? nonMatched : ans;
    }

    public int[] getLpsArray(String s) {
        int[] ans = new int[s.length() + 1];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                ans[i + 1] = ans[i] + 1;
                j++;
            } else {
                j = 0;
            }
        }
        return ans;
    }
}
