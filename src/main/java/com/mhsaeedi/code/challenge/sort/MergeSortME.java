package com.mhsaeedi.code.challenge.sort;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : Momo
 * @since : 30.03.22, Wed
 **/
public class MergeSortME
{
	private static void sort(int[] arr){
		sort(arr,0,arr.length-1);
	}

	private static void sort(int[] arr, int l, int r){
		if(l>=r) return;
		int m = l + (r-l)/2;
		sort(arr,l,m);
		sort(arr,m+1,r);
		merge(arr,l,m,r);
	}

	private static void merge(int[] arr, int l, int m, int r){
		int i=l;
		int j=m+1;
		int[] temp = new int[r-l+1];
		int k=0;
		while(i<=m && j<=r) temp[k++]=arr[i]<arr[j] ? arr[i++] : arr[j++];
		while(i<=m) temp[k++]=arr[i++];
		while(j<=r) temp[k++]=arr[j++];
		k=0;
		while(k<r-l+1) arr[l+k]=temp[k++];
	}

	public static void main(String[] args){
		int[] arr = new int[]{4,57,3,4,5,34,5,7,65,86,873,4};
		int[] copy = Arrays.copyOf(arr,arr.length);
		sort(arr);
		String s = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(s);
		Arrays.sort(copy);
		System.out.println(Arrays.equals(arr,copy));
	}
}
