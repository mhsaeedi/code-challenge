package com.mhsaeedi.code.challenge.datastructure.dijkstra;

import com.mhsaeedi.code.challenge.datastructure.filo.Filo;

/**
 * @author : Momo
 * @since : 23.02.22, Wed
 **/
public class Operation
{
	protected static void execute(Filo<Integer> numbers, Filo<Character> operations)
	{
		int b = numbers.pop().orElseThrow();
		int a = numbers.pop().orElseThrow();
		char op = operations.pop().orElseThrow();
		int n;
		if (op == '+') n = a + b;
		else if (op == '-') n = a - b;
		else if (op == '*') n = a * b;
		else if (op == '/') n = a / b;
		else throw new IllegalArgumentException();
		numbers.push(n);
	}
}
