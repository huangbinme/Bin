package com.review;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Solution_395 {

    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            count[j]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int charCount = count[s.charAt(i) - 'a'];
            if (charCount < k) {
                int ans1 = longestSubstring(s.substring(0, i), k);
                int ans2 = longestSubstring(s.substring(i + 1), k);
                return Math.max(ans1, ans2);
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        List<String> allInputs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            allInputs.add(in.nextLine());
            //System.out.println(in.nextLine());
        }
        Set<String> keyword = new HashSet<>(Arrays.asList(allInputs.get(1).split(" ")));
        int userCount = Integer.parseInt(allInputs.get(0).split(" ")[0]);
        int userStart = 2;
        List<User> ans = new ArrayList<>();
        for(int i = 0; i < userCount; i++){
            int j = userStart;
            String userName = allInputs.get(j).split(" ")[0];
            String[] searchWords = allInputs.get(j+1).split(" ");
            userStart += 2;
            User u = new User(keyword, userName, searchWords);
            ans.add(u);
        }
        ans.sort((u1,u2) -> {
            return u2.keyworkCount - u1.keyworkCount;
        });
        ans.forEach(a -> System.out.println(a.name));
    }

    static class User{
        String name;
        int keyworkCount = 0;
        public User(Set<String> keyword, String name, String[] searchKeyword){
            this.name = name;
            for(int i = 0; i < searchKeyword.length ; i++){
                if(keyword.contains(searchKeyword[i])){
                    keyworkCount++;
                }
            }
        }
    }
}
