package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        String parent = folder[0];
        ans.add(parent);
        for (int i = 1; i < folder.length; i++) {
            if(!(folder[i].startsWith(parent) && folder[i].charAt(parent.length()) == '/')){
                parent = folder[i];
                ans.add(parent);
            }
        }
        return ans;
    }
}
