package com.algorithm.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class BubbleTest {
	protected final Logger LOGGER = LogManager.getLogger(BubbleTest.class);

	@Test
	public void testBubbleSort() {
		BaseSort baseSort = new BubbleSort();
		CommonUtil.sortThenPrintTime(baseSort,CommonUtil.getRandomIntArrayByLength(30000));
	}

}
