package com.mhsaeedi.code.challenge.datastructure.fifo;

import java.util.Objects;

/**
 * @author : Momo
 * @since : 20.02.22, Sun
 **/
public class Fifo<E>
{
	private Node<E> head;

	public boolean push(E e){
		if (Objects.isNull(e)) return false;
		Node<E> newNode = new Node<>(e);
		if(Objects.isNull(head)) {
			head = newNode;
			return true;
		}
		head.setPrev(newNode);
		return true;
	}

	public E poll(){
		if(Objects.isNull(this.head)) return null;
		E res = head.getValue();
		Node<E> newHead = this.head.getPrev();
		head = newHead;
		return res;
	}

	public static void main(String[] args)
	{
		Fifo<String> fifo = new Fifo<>();
		fifo.push("a");
		fifo.push("b");
		fifo.push("c");
		fifo.push(null);
		System.out.println(fifo.poll());
		System.out.println(fifo.poll());
		System.out.println(fifo.poll());
		System.out.println(fifo.poll());
		System.out.println(fifo.poll());
	}

}
