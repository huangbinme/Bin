package com.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindLongestPalindromicSubStringTest {

	@Test
	public void testIfPalindromic() {
		FindLongestPalindromicSubString obj = new FindLongestPalindromicSubString();		
		System.out.println(obj.ifPalindromic("a",0,0));
	}

	@Test
	public void testLongestPalindrome() {
		long startTime = System.currentTimeMillis();
		FindLongestPalindromicSubString obj = new FindLongestPalindromicSubString();		
		System.out.println(obj.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
		long endTime = System.currentTimeMillis();
		System.out.println("it cost :" + (endTime - startTime) + "ms");
	}

}
