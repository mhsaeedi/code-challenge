package com.mhsaeedi.code.challenge.datastructure.dijkstra;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.HashSet;
import java.util.Set;

import com.mhsaeedi.code.challenge.datastructure.filo.Filo;

import static java.lang.Character.*;

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
			if(isDigit(c)) i += handleNumber(i,chars,numbers);
            else if (operationSet.contains(c)) operations.push(c);
			else if(c == ')') doOperation(numbers,operations);
		}
		return numbers.pop().orElseThrow();
	}

	private static void doOperation(Filo<Integer> numbers, Filo<Character> operations)
	{
		int b = numbers.pop().orElseThrow();
		int a = numbers.pop().orElseThrow();
		char op = operations.pop().orElseThrow();
		switch(op){
		case '+':
			numbers.push(a+b);
			break;
		case '-':
			numbers.push(a-b);
			break;
		case '*':
			numbers.push(a*b);
			break;
		case '/':
			numbers.push(a/b);
			break;
		default:
			throw new IllegalArgumentException();
		}


	}

	private static int handleNumber(int index, char[] chars, Filo<Integer> numbers)
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
