package com.algorithem.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {

	@Test
	public void testBubbleSort() {
		int [] input = CommonUtil.getRandomIntAraryByLength(30000);
		Long start = System.currentTimeMillis();
		int[] sortResult = BubbleSort.sort(input);
		Arrays.sort(input);
		Assert.assertArrayEquals(sortResult,input);
		String costTime = "BubbleSort spend "+(System.currentTimeMillis()-start)/1000.0+"s";
		System.out.println(costTime);
	}

}
