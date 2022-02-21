package com.mhsaeedi.code.challenge.datastructure.doubly;

import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author : Momo
 * @since : 21.02.22, Mon
 **/
public class Doubly<E>
{
	private Node<E> head;
	private Node<E> tail;

	public boolean addTail(E e){
		if(isNull(e)) return false;
		Node<E> newTail = new Node<>(e);
		if(isNull(tail)){
			head = newTail;
			tail = newTail;
			return true;
		}
		tail.setNext(newTail);
		newTail.setPrev(tail);
		tail = newTail;
		return true;

	}

	public Optional<E> removeTail(){
		if(isNull(tail)) return Optional.empty();
		E res = tail.getValue();
		tail.setValue(null);
		tail = tail.getPrev();
		if(nonNull(tail)) tail.setNext(null);
		return Optional.ofNullable(res);
	}

	public boolean addHead(E e){
		if(isNull(e)) return false;
		Node<E> newHead = new Node<>(e);
		if(isNull(head)) {
			head = newHead;
			tail = newHead;
			return true;
		}
		head.setPrev(newHead);
		newHead.setNext(head);
		head = newHead;
		return true;
	}

	public Optional<E> removeHead(){
		if(isNull(head)) return Optional.empty();
		E res = head.getValue();
		head.setValue(null);
		head = head.getNext();
		if(nonNull(head))head.setPrev(null);
		return Optional.ofNullable(res);
	}

	public static void main(String[] args)
	{
		Doubly<String> doubly = new Doubly<>();
		doubly.addHead("a");
		doubly.addTail("b");
		doubly.addHead("c");
		doubly.addTail("d");
		doubly.addHead("e");
		doubly.addTail("f");
		// ecabdf
		System.out.println(doubly.removeHead().orElse("nothing"));
		System.out.println(doubly.removeTail().orElse("nothing"));
		System.out.println(doubly.removeHead().orElse("nothing"));
		System.out.println(doubly.removeTail().orElse("nothing"));
		System.out.println(doubly.removeHead().orElse("nothing"));
		System.out.println(doubly.removeTail().orElse("nothing"));
		System.out.println(doubly.removeTail().orElse("nothing"));
		System.out.println(doubly.removeHead().orElse("nothing"));
		System.out.println(doubly.removeTail().orElse("nothing"));
		System.out.println(doubly.removeHead().orElse("nothing"));
	}
}
