package com.mhsaeedi.code.challenge.backtracking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Momo
 * @since : 05.04.22, Tue
 **/
public class Permutation
{
	public static void main(String[] args){
		permute(new int[]{1,2,3});
	}
	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(new LinkedList<>(), nums, 0);
		return res;
	}

	private static void backtrack(List<Integer> temp, int[] nums, int start){
		//if(temp.size()==nums.length)
			System.out.println(temp);
		for(int i=start ; i<nums.length ; i++){
			//if(temp.contains(nums[i])) continue;
			temp.add(nums[i]);
			backtrack(temp,nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
}
