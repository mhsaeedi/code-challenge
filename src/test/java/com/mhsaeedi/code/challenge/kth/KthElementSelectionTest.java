package com.mhsaeedi.code.challenge.kth;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.mhsaeedi.code.challenge.kth.ArrayBuilderForTest.arr;
import static com.mhsaeedi.code.challenge.kth.ArrayBuilderForTest.size;
import static com.mhsaeedi.code.challenge.kth.ArrayBuilderForTest.sortedArr;
import static com.mhsaeedi.code.challenge.kth.KthElementSelection.findKthLargest;

/**
 * @author : Mohammad <mohammad.saeedi@visual-meta.com>
 * @since : 14.02.22, Mon
 **/
class KthElementSelectionTest
{

	@Test
	void Should_FindCorrectElement()
	{
		assertEquals(findKthLargest(arr, 49 + 1), sortedArr[49]);
		IntStream.range(0, size).forEach(n -> assertEquals(findKthLargest(arr, n + 1), sortedArr[n]));
	}

}
