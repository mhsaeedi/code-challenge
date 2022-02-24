package com.mhsaeedi.code.challenge.datastructure.filo;

/**
 * @author : Momo
 * @since : 20.02.22, Sun
 **/
public class Node<E>
{
	private Node<E> next;
	private E value;

	public Node(E value){
		this.value = value;
	}

	public void setNext(Node<E> next){
		this.next = next;
	}
	public Node<E> getNext(){
		return next;
	}

	public E getValue()
	{
		return value;
	}
}
