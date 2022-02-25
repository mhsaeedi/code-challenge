package com.mhsaeedi.code.challenge.datastructure.filo;

import static java.lang.System.*;
import static java.util.Objects.*;

/**
 * @author : Momo
 * @since : 20.02.22, Sun
 **/
public class Filo<E>
{

	private Node<E> first;
	private int size;

	public void push(E data)
	{
		Node<E> node = new Node<>(data);
		if (nonNull(first)) node.setNext(first);
		first = node;
		size++;

	}

	public E pop(){
		if(isNull(first)) return null;
		E res = first.getValue();
		first = first.getNext();
		size--;
		return res;
	}

	public E peek(){
		return isNull(first) ? null : first.getValue();
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){ return size == 0;}

	public static void main(String[] args)
	{
		Filo<String> filo = new Filo<>();
		filo.push("a");
		filo.push("b");
		filo.push("c");
		out.println(filo.pop());
		out.println(filo.pop());
		out.println(filo.pop());
		out.println(filo.pop());
	}

}
