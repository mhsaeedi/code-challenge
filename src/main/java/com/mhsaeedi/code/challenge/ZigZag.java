package com.mhsaeedi.code.challenge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : Momo
 * @since : 17.03.22, Thu
 **/
public class ZigZag
{
	public String convert(String s, int numRows) {
		List<StringBuilder> sbs = prepareSbs(numRows);
		int sbi = 0;
		boolean down = true;
		for(int i=0 ; i<s.length() ; i++){
			sbs.get(sbi).append(s.charAt(i));
			sbi = down ? sbi+1 : sbi-1;
			down = (sbi == 0 || sbi == numRows) != down;
		}

		return sbs.stream().reduce(new StringBuilder(), StringBuilder::append).toString();


	}
	private static List<StringBuilder> prepareSbs(int numRows){
		return IntStream.range(0,numRows).mapToObj(i -> new StringBuilder()).collect(Collectors.toList());
	}
}
