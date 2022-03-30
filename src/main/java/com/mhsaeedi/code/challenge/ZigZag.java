package com.mhsaeedi.code.challenge;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
   this.val = val;
   this.left = left;
   this.right = right;
     }
 }

/**
 * @author : Momo
 * @since : 17.03.22, Thu
 **/
public class ZigZag
{
	public static void main(String[] args)
	{
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2,four,five);
		TreeNode three = new TreeNode(3);
		TreeNode one = new TreeNode(1,two,three);
		System.out.println(inorder(one));
		System.out.println(preorder(one));
		System.out.println(postorder(one));
	}

	private static List<Integer> postorder(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode node = root;
		while(!stack.isEmpty() || null!=node){
			while(null!=node){
				stack.push(node);
				if(null!=node.right) stack.push(node.right);
				node = node.left;
			}
			TreeNode pop = stack.pop();
			res.add(pop.val);
		}
		return res;
	}

	private static List<Integer> preorder(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode pop = stack.pop();
			res.add(pop.val);
			if(null!=pop.right) stack.push(pop.right);
			if(null!=pop.left) stack.push(pop.left);
		}
		return res;
	}

	private static List<Integer> inorder(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while(!stack.isEmpty() || null!=node){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			node = stack.pop();
			res.add(node.val);
			node = node.right;
		}
		return res;
	}

	private static String sort(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c).intern();
	}

	private static Collection<List<String>> group(String[] s){
		Map<String,List<String>> map = Arrays.stream(s).map(String::toCharArray).map(c -> {
			Arrays.sort(c);
			return new String(c);
		}).collect(Collectors.toMap(c->c, c -> new ArrayList<>(),(a,b)-> a));

		for(String w:s){
			char[] c = w.toCharArray();
			Arrays.sort(c);
			map.get(new String(c)).add(w);
		}

		return new ArrayList<>(map.values());
	}



	private static List<StringBuilder> prepareSbs(int numRows)
	{
		return IntStream.range(0, numRows).mapToObj(i -> new StringBuilder()).collect(Collectors.toList());
	}

	public String convert(String s, int numRows)
	{
		List<StringBuilder> sbs = prepareSbs(numRows);
		int sbi = 0;
		boolean down = true;
		for (int i = 0; i < s.length(); i++)
		{
			sbs.get(sbi).append(s.charAt(i));
			sbi = down ? sbi + 1 : sbi - 1;
			down = (sbi == 0 || sbi == numRows) != down;
		}

		return sbs.stream().reduce(new StringBuilder(), StringBuilder::append).toString();

	}
}
