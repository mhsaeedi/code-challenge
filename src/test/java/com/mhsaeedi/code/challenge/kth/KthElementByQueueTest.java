package com.mhsaeedi.code.challenge.kth;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.mhsaeedi.code.challenge.kth.ArrayBuilderForTest.arr;
import static com.mhsaeedi.code.challenge.kth.ArrayBuilderForTest.size;
import static com.mhsaeedi.code.challenge.kth.ArrayBuilderForTest.sortedArr;
import static com.mhsaeedi.code.challenge.kth.KthElementByQueue.findKthLargest;

/**
 * @author : Momo
 * @since : 14.02.22, Mon
 **/
class KthElementByQueueTest
{

	@Test
	void Should_FindCorrectElement()
	{
		IntStream.range(0, size).forEach(n -> assertEquals(findKthLargest(arr, n + 1), sortedArr[n]));
	}

}
