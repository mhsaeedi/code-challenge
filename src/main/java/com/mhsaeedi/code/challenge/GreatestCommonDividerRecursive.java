package com.mhsaeedi.code.challenge;

/**
 * @author : Mohammad <mohammad.saeedi@visual-meta.com>
 * @since : 14.02.22, Mon
 **/
public class GreatestCommonDividerRecursive
{
	public static long getGCD(long a, long b)
	{
		long c = Math.abs(a);
		long d = Math.abs(b);
		long remaining = Math.max(c, d) % Math.min(c, d);
		return remaining == 0 ? Math.min(c, d) : getGCD(d, remaining);
	}
}
