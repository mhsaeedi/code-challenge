package com.mhsaeedi.code.challenge.datastructure.fifo;

import java.util.Objects;

/**
 * @author : Momo
 * @since : 21.02.22, Mon
 **/
public class Node<E>
{
	private E value;
	private Node<E> prev;

	public Node(E e){
		value = e;
	}

	public void setPrev(Node<E> prev){
		if(Objects.isNull(this.prev)) this.prev = prev;
		else this.prev.setPrev(prev);
	}

	public Node<E> getPrev(){
		return prev;
	}

	public E getValue()
	{
		return this.value;
	}
}
