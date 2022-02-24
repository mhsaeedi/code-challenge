package com.mhsaeedi.code.challenge.datastructure.binarytree;

import static java.util.Objects.isNull;

/**
 * @author : Momo
 * @since : 23.02.22, Wed
 **/
class Node<E extends Comparable<E>>
{
	protected E data;
	protected Node<E> parent;
	protected Node<E> left;
	protected Node<E> right;

	public Node(E data,Node<E> parent)
	{
		this.data = data;
		this.parent = parent;
	}

}
