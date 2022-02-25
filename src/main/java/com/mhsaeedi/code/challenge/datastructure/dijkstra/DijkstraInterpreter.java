package com.mhsaeedi.code.challenge.datastructure.dijkstra;

import java.util.Set;

import com.mhsaeedi.code.challenge.datastructure.filo.Filo;

import static java.lang.Character.*;
import static com.mhsaeedi.code.challenge.datastructure.dijkstra.Operation.execute;

/**
 * @author : Momo
 * @since : 21.02.22, Mon
 **/
public class DijkstraInterpreter{
	private static final Set<Character> operationSet = Set.of('+','-','*','/');
	public static int interpret(String expressions){
		Filo<Integer> numbers = new Filo<>();
		Filo<Character> operations = new Filo<>();
		char[] chars = expressions.toCharArray();
		for(int i=0;i<chars.length;i++){
			char c = chars[i];
			if(isDigit(c)) i += getNumber(i,chars,numbers);
            else if (operationSet.contains(c)) operations.push(c);
			else if(c == ')') execute(numbers,operations);
		}
		return numbers.pop();
	}



	private static int getNumber(int index, char[] chars, Filo<Integer> numbers)
	{

		int counter = -1;
		StringBuilder number = new StringBuilder();
		while(isDigit(chars[index])) {
			number.append(chars[index]);
			index++;
			counter++;
		}
		numbers.push(Integer.parseInt(number.toString()));
		return counter;
	}

	public static void main(String[] args)
	{
		System.out.println(interpret("((10*12)+(8-1))"));
	}

}
