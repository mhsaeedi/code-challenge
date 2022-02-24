package com.mhsaeedi.code.challenge.datastructure.doubly;

/**
 * @author : Momo
 * @since : 21.02.22, Mon
 **/
public class Node<E>
{
	private E value;
	private Node<E> next;
	private Node<E> prev;
	public Node(E e){
		value = e;
	}

	public void setNext(Node<E> next)
	{
		this.next = next;
	}

	public E getValue()
	{
		return value;
	}

	public Node<E> getNext()
	{
		return next;
	}

	public void setPrev(Node<E> prev)
	{
		this.prev = prev;
	}

	public Node<E> getPrev()
	{
		return prev;
	}

	public void setValue(E value)
	{
		this.value = value;
	}
}
