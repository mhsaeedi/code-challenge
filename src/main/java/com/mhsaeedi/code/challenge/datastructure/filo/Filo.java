package com.mhsaeedi.code.challenge.datastructure.filo;

import java.util.Objects;
import java.util.Optional;

/**
 * @author : Momo
 * @since : 20.02.22, Sun
 **/
public class Filo<E>
{

	private Node<E> first;

	public boolean push(E e)
	{
		if(Objects.isNull(e)) return false;
		if (Objects.isNull(first))
		{
			first = new Node<>(e);
			return true;
		}
		Node<E> newFirst = new Node<>(e);
		newFirst.setNext(first);
		first = newFirst;
		return true;
	}

	public Optional<E> pop(){
		if(Objects.isNull(first)) return Optional.empty();
		E res = first.getValue();
		Node<E> newFirst = first.getNext();
		first = newFirst;
		return Optional.of(res);
	}

	public static void main(String[] args)
	{
		Filo<String> filo = new Filo<>();
		filo.push(null);
		filo.push("a");
		filo.push("b");
		filo.push("c");
		System.out.println(filo.pop().orElse("nothing"));
		System.out.println(filo.pop().orElse("nothing"));
		System.out.println(filo.pop().orElse("nothing"));
		System.out.println(filo.pop().orElse("nothing"));
	}

}
