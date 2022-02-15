package com.mhsaeedi.code.challenge.search;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.mhsaeedi.code.challenge.search.BinarySearch.search;

/**
 * @author : Mohammad <mohammad.saeedi@visual-meta.com>
 * @since : 15.02.22, Tue
 **/
class BinarySearchTest
{

	@Test
	void Should_ReturnExpectedResult()
	{
		int[] arr = IntStream.range(0, 1000).map(n -> ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).sorted().toArray();
		IntStream.range(0, arr.length).forEach(n -> assertEquals(n, search(arr, arr[n])));

	}

}
