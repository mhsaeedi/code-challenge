package com.mhsaeedi.code.challenge.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : Momo
 * @since : 05.04.22, Tue
 **/
public class QuickSort2
{
	public static void main(String[] args){
		int[] arr = new int[]{5,6,7,6,7,8,9,8,0,9,9,6,5,4,3,2,8,9};
		quickSort(arr,0,arr.length-1);
	}

	private static void quickSort(int[] arr, int l, int r){
		if(l>r) return;
		int p = partition(arr,l,r);
		quickSort(arr,l,p-1);
		quickSort(arr,p+1,r);
	}

	private static int partition(int[] arr, int l, int r){
		int i=l+1;
		int j=r;
		int pivot=arr[l];
		while(i<=j){
			while(i<=j && arr[j]>=pivot) j--;
			while(i<=j && arr[i]<pivot) i++;
			if(i<=j) swap(arr,i,j);
		}
		swap(arr, j, l);
		return j;
	}

	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
