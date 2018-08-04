package com.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/** 
* @author Bin
* @version 2018年8月4日 下午9:45:44
* @Description 
*/
public class BubbleTest {

	@Test
	public void testBubbleSort() {
		int [] input = {9,8,7,1,2,2,5,4,100,9999,-4};
		Bubble Bubble = new Bubble();
		System.out.println(Arrays.toString(Bubble.bubbleSort(input)));
	}

}
