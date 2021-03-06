package com.mhsaeedi.code.challenge.gcd;

import static java.lang.Math.*;

/**
 * @author : Momo
 * @since : 14.02.22, Mon
 **/
public class GCDRecursive
{
	public static long getGCD(long a, long b)
	{
		long c = abs(a);
		long d = abs(b);
		long remaining = max(c, d) % min(c, d);
		return remaining == 0 ? min(c, d) : getGCD(d, remaining);
	}
}
