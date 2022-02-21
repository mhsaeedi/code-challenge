package com.mhsaeedi.code.challenge.goo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.mhsaeedi.code.challenge.goo.StringDecompressor.*;

/**
 * @author : Momo
 * @since : 15.02.22, Tue
 **/
class StringDecompressorTest
{
	@Test
	void Should_DecompressCorrectly()
	{
		assertEquals(decompress("3[abc]4[ab]c"), "abcabcabcababababc");
		assertEquals(decompress("10[a]"), "aaaaaaaaaa");
		assertEquals(decompress("2[3[a]b]"), "aaabaaab");
	}

}
