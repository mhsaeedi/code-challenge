package com.mhsaeedi.code.challenge.kth;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : Mohammad <mohammad.saeedi@visual-meta.com>
 * @since : 14.02.22, Mon
 **/
public class KthElementByQueue
{
	public static Long findKthLargest(Long[] arr, long k)
	{
		Queue<Long> q = new PriorityQueue<>();
		for (long n : arr)
		{
			q.offer(n);
			if (q.size() > k)
			{
				q.poll();
			}
		}
		return q.peek();

	}
}
