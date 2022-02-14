package com.mhsaeedi.code.challenge;

import static java.lang.Math.*;

/**
 * @author : Mohammad <mohammad.saeedi@visual-meta.com>
 * @since : 14.02.22, Mon
 **/
public class GCDIterative
{
	public static long getGCD(long a, long b)
	{
		long c = abs(a);
		long d = abs(b);
		long remaining = getRemaining(c, d);
		while (remaining != 0)
		{
			c = d;
			d = remaining;
			remaining = getRemaining(c, d);
		}
		return min(c,d);
	}

	private static long getRemaining(long c, long d)
	{
		return max(c, d) % min(c, d);
	}
}
