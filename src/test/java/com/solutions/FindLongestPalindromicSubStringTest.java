package com.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
* @author Bin
* @version 2018年7月23日 下午10:46:11
* @Description 
*/
public class FindLongestPalindromicSubStringTest {

	@Test
	public void testIfPalindromic() {
		FindLongestPalindromicSubString obj = new FindLongestPalindromicSubString();		
		System.out.println(obj.ifPalindromic("a",0,0));
	}

	@Test
	public void testLongestPalindrome() {
		FindLongestPalindromicSubString obj = new FindLongestPalindromicSubString();		
		System.out.println(obj.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}
