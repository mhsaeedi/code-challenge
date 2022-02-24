package com.mhsaeedi.code.challenge.kth;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : Momo
 * @since : 14.02.22, Mon
 **/
public class KthElementSelection
{
	public static long findKthLargest(Long[] nums, int k) {
		if(nums.length == 1) return nums[0];

		int left = 0;
		int right = nums.length - 1;

		while(left <= right){
			int pivotPos = partition(nums, left, right);
			if(pivotPos - left + 1 < k) {
				k = k - (pivotPos - left + 1);//shrink k value
				left = pivotPos + 1;//move left to pivotPos + 1
			} else if(pivotPos - left + 1 > k){
				right = pivotPos - 1;//shrink right by 1 at least
			} else{
				return nums[pivotPos];
			}
		}
		return 0;
	}

	//make elements value between [0, leftBound] are all >= pivot
	private static int partition(Long[] array, int left, int right){
//		int pivotIndex = left + (right - left)/2;
		int pivotIndex = ThreadLocalRandom.current().nextInt(left,right+1);
		long pivot = array[pivotIndex];
		swap(array, pivotIndex, right);

		int leftBound = left;
		int rightBound = right - 1;
		while(leftBound <= rightBound){
			if(array[leftBound] >= pivot){
				leftBound++;
			} else if(array[rightBound] < pivot){
				rightBound--;
			} else{
				swap(array, leftBound++, rightBound--);
			}
		}
		swap(array, leftBound, right);
		return leftBound;
	}

	private static void swap(Long[] array, int left, int right){
		long temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
