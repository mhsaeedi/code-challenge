package com.mhsaeedi.code.challenge.datastructure.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.mhsaeedi.code.challenge.datastructure.filo.Filo;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author : Momo
 * @since : 23.02.22, Wed
 **/
public class BinaryTree<E extends Comparable<E>>
{
	private Node<E> root;
	private int size;

    @SafeVarargs
    public final void add(final E... el){
		for(E e:el)
		{
			if (isNull(root)) root = new Node<>(e, null);
			else add(e, root);
			size++;
		}
   }


   @SafeVarargs
   public final void remove(final E... data){
		for(E d:data) {
			if(remove(d,root,null)) size--;
		}
   }

   public E max(){
		return max(root).data;
   }

   private Node<E> max(Node<E> node) {
		while(nonNull(node.right)) node = node.right;
		return node;
   }

   public E min(){
		return min(root).data;
   }

   private Node<E> min(Node<E> node){
		while(nonNull(node.left)) node = node.left;
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
		else if(isNull(node.left)) removeMeWithNoLeft(node,parent);
		else if(isNull(node.right)) removeMeWithNoRight(node,parent);
		else removeWithSubTree(node);
		return true;
   }

   private void removeWithSubTree(Node<E> node){
		Node<E> max = max(node.left);
		node.data = max.data;
		remove(max.data,max,max.parent);

   }

   private void removeMeWithNoLeft(Node<E> node,Node<E> parent){
		if(isNull(parent)) root = node.right;
		else if(node == parent.left) parent.left = node.right;
		else parent.right = node.right;

   }
   private void removeMeWithNoRight(Node<E> node,Node<E> parent){
		if(isNull(parent)) root = node.left;
		else if(node == parent.left) parent.left = node.left;
		else if(node == parent.right) parent.right = node.left;
   }
   private void removeLeaf(Node<E> node,Node<E> parent){
		if(isNull(parent)) root = null;
		else if(node == parent.left) parent.left = null;
		else if(node == parent.right) parent.right = null;
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

	public int size()
	{
		return size;
	}

	public List<E> sortedRecursive()
	{
		List<E> result = new ArrayList<E>();
		sortedRecursive(result, root);
		return result;
	}

	public List<E> sortedIterative(){
		List<E> res = new ArrayList<>();
		Filo<Node<E>> filo = new Filo<>();
		Node<E> current = root;
		while(!filo.isEmpty() || nonNull(current)){
			if(nonNull(current)){
				current = current.left;
				filo.push(current);
			} else {
				Node<E> node = filo.pop();
				res.add(node.data);
				filo.push(node.right);
			}
		}
		return res;
	}

	public boolean equalsTo(BinaryTree<E> o)
	{
		return equalsToRec(root, o.root);
	}

	private boolean equalsTo(Node<E> n,Node<E> o){
		if(isNull(n) || isNull(o)) return n == o;
		return n.data.equals(o.data) && equalsTo(n.left,o.left) && equalsTo(n.right,o.right);
	}

	private boolean equalsToRec(Node<E> one,Node<E> other){
		Filo<Node<E>> stack1 = new Filo<>();
		Filo<Node<E>> stack2 = new Filo<>();
		stack1.push(one);
		stack2.push(other);
		while(!stack1.isEmpty() && !stack2.isEmpty())
		{
			Node<E> a = stack1.pop();
			Node<E> b = stack2.pop();
			if(isNull(a) && isNull(b)) continue;
			if((isNull(a) || isNull(b))) return false;
			if(!a.data.equals(b.data)) return false;
			stack1.push(a.left);
			stack2.push(b.left);
			stack1.push(a.right);
			stack2.push(b.right);
		}
		return true;
	}



	private void sortedRecursive(List<E> result, Node<E> node){
		if(isNull(node)) return;
		sortedRecursive(result,node.left);
		result.add(node.data);
		sortedRecursive(result,node.right);
	}

   public static void main(String[] args){
		BinaryTree<Integer> tree1 = new BinaryTree<>();
		tree1.add(1000,900,1100,800,1200,700,1300,600,950,910,990,1150,4000,960);

		BinaryTree<Integer> tree2 = new BinaryTree<>();
		tree2.add(1000,900,1100,800,1200,700,1300,600,950,910,990,1150,4000,960);

		BinaryTree<Integer> tree3 = new BinaryTree<>();
		tree3.add(1000,900,1100,800,1200,700,1300,600,950,910,990,1150,4000);

	   BinaryTree<Integer> tree4 = new BinaryTree<>();
	   tree4.add(900,1100,800,1200,700,1300,600,950,910,990,1150,4000,960);

	   System.out.println(tree1.equalsTo(tree2));
;


   }

}
