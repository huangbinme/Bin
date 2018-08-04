package com.solutions;

public class FindLongestPalindromicSubString {
	
	public boolean ifPalindromic(String str,int i,int j){
		while(i<=j){
			if(str.charAt(i)==str.charAt(j)){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public String longestPalindrome(String s) {		
		for(int size=s.length();size>=1;size--){
			for(int i=s.length()-size;i>=0;i--){
				int j = size-1+i;
				if(ifPalindromic(s,i,j)==true){
					return s.substring(i, j+1);
				}
			}
		}
		return s.substring(0,1);
	}

}
