package com.mhsaeedi.code.challenge.kth;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : Momo
 * @since : 14.02.22, Mon
 **/
public class ArrayBuilderForTest
{
	protected static final Long[] arr;
	protected static final Long[] sortedArr;
	protected static final int size = 100;

	static
	{
		arr = new Long[size];
		for (int i = 0; i < size; i++)
		{
			arr[i] = ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, Long.MAX_VALUE);
		}
		sortedArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(sortedArr, Collections.reverseOrder());

	}
}
