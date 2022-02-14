package com.mhsaeedi.code.challenge;

/**
 * @author : Mohammad <mohammad.saeedi@visual-meta.com>
 * @since : 14.02.22, Mon
 **/
public class GreatestCommonDividerIterative
{
	public static long getGCD(long a, long b)
	{
		long c = Math.abs(a);// 125
		long d = Math.abs(b);// 25
		long remaining = getRemaining(c, d);
		while (remaining != 0)
		{
			c = d;
			d = remaining;
			remaining = getRemaining(c, d);
		}
		return Math.min(c,d);
	}

	private static long getRemaining(long c, long d)
	{
		return Math.max(c, d) % Math.min(c, d);
	}
}
