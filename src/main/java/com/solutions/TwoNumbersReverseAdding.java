package com.solutions;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
/** 
* @author Bin
* @version 2018年7月22日 上午1:19:15
* @Description LeetCode link:https://leetcode-cn.com/problems/add-two-numbers/description/
*/

public class TwoNumbersReverseAdding {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static String NodeToString(ListNode l) {
		List<Integer> list = new ArrayList<Integer>();
		ListNode tmp = l;
		while (true) {
			if (tmp.next == null) {
				list.add(tmp.val);
				tmp = l.next;
				break;
			} else {
				list.add(tmp.val);
				tmp = tmp.next;
			}
		}

		StringBuffer str = new StringBuffer();
		for (Integer i : list) {
			str.append(i.toString());
		}

		return str.toString();
	}

	public ListNode NumberToNode(String num) {
		List<Integer> list = new ArrayList<Integer>();
		String[] numberStringArray = num.toString().split("");
		for (String str : numberStringArray) {
			list.add(Integer.valueOf(str));
		}
		List<ListNode> nodeList = new ArrayList<ListNode>();

		for (Integer x : list) {
			nodeList.add(new ListNode(x));
		}
		ListNode result = new ListNode(0);
		result.val = nodeList.get(0).val;

		ListNode tem = result;

		for (int i = 0; i < list.size() - 1; i++) {
			tem.next = nodeList.get(i + 1);
			tem = tem.next;
		}
		return result;
	}

	public static String reverseString(String numStr) {
		String[] strArray = numStr.split("");
		String[] reverseStrArray = new String[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			reverseStrArray[reverseStrArray.length - 1 - i] = strArray[i];
		}

		StringBuffer str2 = new StringBuffer();
		for (String stringNum : reverseStrArray) {
			str2.append(stringNum.toString());
		}
		return str2.toString();
	}

	public static String addNum(String str1, String str2) {
		BigDecimal b1 = new BigDecimal(str1);
		BigDecimal b2 = new BigDecimal(str2);
		return b1.add(b2).toString();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String num1 = NodeToString(l1);
		String num2 = NodeToString(l2);
		String reverseNum1 = reverseString(num1);
		String reverseNum2 = reverseString(num2);
		String resultString = addNum(reverseNum1, reverseNum2);
		return NumberToNode(reverseString(resultString));
	}
}
