package com.mhsaeedi.code.challenge.datastructure.binarytree;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author : Momo
 * @since : 23.02.22, Wed
 **/
public class BinaryTree<E extends Comparable<E>>
{
	private Node<E> root;
    public void add(E e){
	   if(isNull(root)) root = new Node<>(e,null);
	   else add(e,root);
   }

   public void remove(E data){
		remove(data,root,null);
   }

   public E max(){
		return max(root).data;
   }

   private Node<E> max(Node<E> node) {
		while(nonNull(node.right)) node = node.right;
		return node;
   }

   private boolean remove(E data,Node<E> node, Node<E> parent){
		int compare = data.compareTo(node.data);
		if(compare == 0) return removeMe(node,parent);
		else if(compare < 0 && nonNull(node.left)) return remove(data,node.left,node);
		else if(compare > 0 && nonNull(node.right)) return remove(data,node.right,node);
		else return false;
   }

   private boolean removeMe(Node<E> node, Node<E> parent){
		if(isNull(node.left) && isNull(node.right)) removeLeaf(node,parent);
		else if(isNull(node.left)) noLeftRemove(node,parent);
		else if(isNull(node.right)) noRightRemove(node,parent);
		else removeWithSubTree(node,parent);
		return true;
   }

   private void removeWithSubTree(Node<E> node,Node<E> parent){
		Node<E> max = max(node.left);
		if(isNull(parent)) removeRoot(max);
		else if(node == parent.left) parent.left = max;
		else parent.right = max;
   }

   private void removeRoot(Node<E> max)
   {
	   if(nonNull(max.left)) max.parent.right = max.left;
	   else max.parent.right = null;

	   max.left = root.left;
	   max.right = root.right;
	   root = max;

   }

   private void noLeftRemove(Node<E> node,Node<E> parent){
		if(isNull(parent)) root = node.right;
		else if(node == parent.left) parent.left = node.right;
		else parent.right = node.right;

   }
   private void noRightRemove(Node<E> node,Node<E> parent){
		if(isNull(parent)) root = node.left;
		else if(node == parent.left) parent.left = node.left;
		else parent.right = node.left;
   }
   private void removeLeaf(Node<E> node,Node<E> parent){
		if(isNull(parent)) root = null;
		else if(node == parent.left) parent.left = null;
		else parent.right = null;
   }

   private void add(E data,Node<E> node){
		if(data.compareTo(node.data) < 0) addLeft(data,node);
		else addRight(data,node);
   }
   private void addLeft(E data, Node<E> node){
		if(isNull(node.left)) node.left = new Node<>(data,node);
		else add(data,node.left);
   }
   private void addRight(E data,Node<E> node){
		if(isNull(node.right)) node.right = new Node<>(data,node);
		else add(data,node.right);
   }

   public static void main(String[] args){
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.add(1000);
		tree.add(900);
		tree.add(1100);
		tree.add(800);
		tree.add(1200);
		tree.add(700);
		tree.add(1300);
		tree.add(600);
		tree.add(950);
		tree.add(910);
		tree.add(990);
		tree.add(1150);
		tree.add(4000);
		tree.add(960);

		tree.remove(1100);
		tree.remove(4000);




   }

}
