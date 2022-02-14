package com.mhsaeedi.code.challenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.mhsaeedi.code.challenge.GCDIterative.getGCD;

/**
 * @author : Mohammad <mohammad.saeedi@visual-meta.com>
 * @since : 14.02.22, Mon
 **/
class GCDRecursiveTest
{

	@Test
	void Should_ReturnGreatestCommonDivider_When_InputIsNormalRecursive()
	{
		assertEquals(3, getGCD(9, 3));
		assertEquals(3, getGCD(3, 9));

		assertEquals(80, getGCD(124_346_655_680L, 345_344_564_560L));
		assertEquals(80, getGCD(345_344_564_560L, 124_346_655_680L));

		assertEquals(800, getGCD(124_346_655_6800L, 345_344_564_5600L));
		assertEquals(800, getGCD(345_344_564_5600L, 124_346_655_6800L));

		assertEquals(9, getGCD(81, 72));
		assertEquals(9, getGCD(72, 81));
	}

	@Test
	void Should_ReturnGreatestCommonDivider_When_InputHasMinus()
	{
		assertEquals(3, getGCD(-9, -3));
		assertEquals(3, getGCD(9, -3));
		assertEquals(3, getGCD(-3, -9));
		assertEquals(3, getGCD(-3, 9));

		assertEquals(80, getGCD(-124_346_655_680L, -345_344_564_560L));
		assertEquals(80, getGCD(-124_346_655_680L, 345_344_564_560L));
		assertEquals(80, getGCD(124_346_655_680L, -345_344_564_560L));
		assertEquals(80, getGCD(-345_344_564_560L, -124_346_655_680L));

		assertEquals(800, getGCD(-124_346_655_6800L, -345_344_564_5600L));
		assertEquals(800, getGCD(-345_344_564_5600L, -124_346_655_6800L));
		assertEquals(800, getGCD(345_344_564_5600L, -124_346_655_6800L));
		assertEquals(800, getGCD(-345_344_564_5600L, 124_346_655_6800L));

		assertEquals(9, getGCD(-81, -72));
		assertEquals(9, getGCD(-72, -81));
		assertEquals(9, getGCD(72, -81));
		assertEquals(9, getGCD(-72, 81));
	}

	@Test
	void Should_ThrowArithmeticException_When_SmallerAbsoluteNumberIsZero()
	{
		Class<ArithmeticException> arithmetic = ArithmeticException.class;
		assertThrows(arithmetic, () -> getGCD(80, 0));
		assertThrows(arithmetic, () -> getGCD(-80, 0));
		assertThrows(arithmetic, () -> getGCD(0, 80));
		assertThrows(arithmetic, () -> getGCD(0, -80));
		assertThrows(arithmetic, () -> getGCD(0, 0));
	}
}
