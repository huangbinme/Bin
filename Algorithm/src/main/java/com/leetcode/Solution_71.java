package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_71 {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        String[] strings = path.split("/");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null && strings[i].length() > 0 && !strings[i].equals(".") && !strings[i].equals("..")) {
                list.add(strings[i]);
            } else if (strings[i] != null && strings[i].equals("..")) {
                if (list.size() > 0) list.remove(list.size() - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("/").append(list.get(i));
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
