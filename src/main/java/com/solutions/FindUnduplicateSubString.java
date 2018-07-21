package com.solutions;

import java.util.HashSet;
import java.util.Set;

/** 
* @author Bin
* @version 2018年7月22日 上午1:19:15
* @Description LeetCode link:https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
*/
public class FindUnduplicateSubString {
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int strLength = s.length();
		int left_pointer = 0;
		int rigth_pointer = 0;
		Set<Character> set = new HashSet<>();
		while (left_pointer < strLength && rigth_pointer < strLength) {
			if (!set.contains(s.charAt(rigth_pointer))) {
				set.add(s.charAt(rigth_pointer));
				rigth_pointer++;
				result = Math.max(result, rigth_pointer - left_pointer);
			} else {
				set.remove(s.charAt(left_pointer));
				left_pointer++;
			}
		}
		return result;
	}
}
