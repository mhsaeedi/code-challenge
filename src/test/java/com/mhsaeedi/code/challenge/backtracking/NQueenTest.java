package com.mhsaeedi.code.challenge.backtracking;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.mhsaeedi.code.challenge.backtracking.BoardBuilder.*;
import static com.mhsaeedi.code.challenge.backtracking.NQueen.*;

/**
 * @author : Momo
 * @since : 15.02.22, Tue
 **/
class NQueenTest
{
	@Test
	void Should_ReturnTrue_When_SizeIsLargerThan4()
	{
		IntStream.range(4,16).forEach(size -> assertReturn(size,true));
	}

	@Test
	void Should_ReturnFalse_When_SizeIsLessThan4()
	{
		IntStream.range(0,4).forEach(size -> assertReturn(size,false));
	}

	private static void assertReturn(int size,boolean expected)
	{
		assertEquals(expected, solve(buildBoard(size)));
	}

}
