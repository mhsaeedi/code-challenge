package com.mhsaeedi.code.challenge.goo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author : Momo
 * @since : 15.02.22, Tue
 **/
public class StringDecompressor
{
	// 2[3[a]b]
	public static String decompress(String exp){
		return decompress(exp, 0);
	}

	private static String decompress(String exp, int p){
		char charAtP = exp.charAt(p);
		if('[' == charAtP) return handleOpenBracket(exp,p,charAtP);
		else if (']' == charAtP)  return handleCloseBracket(exp,p,charAtP);
		else if (number(charAtP) != -1) return handleNumber(exp,p,charAtP);
		else return handleLetter(exp,p,charAtP);
	}

	private static String handleLetter(String exp, int p, char charAtP)
	{
		return null;
	}

	private static String handleNumber(String exp, int p, char charAtP)
	{
		String number = Character.toString(charAtP);
//		while (number(exp.charAt(p+1)))
		return null;
	}

	private static String handleCloseBracket(String exp, int p, char charAtP)
	{
		return decompress(exp,p+1);
	}

	private static String handleOpenBracket(String exp, int p, char charAtP)
	{
		return decompress(exp,p+1);
	}

	private static int number(char target){
		try{
			return Integer.parseInt(Character.toString(target));
		}catch(NumberFormatException e){
			return -1;
		}
	}

}
