package com.mhsaeedi.code.challenge.sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : Momo
 * @since : 16.02.22, Wed
 **/

class MergeSort
{
	public static void sort(int[] arr)
	{
		int[] temp = new int[arr.length];
		mergeSort(arr,temp, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr,int[] temp, int l, int r)
	{
		if(l<r) {
		int m = l + (r-l)/2;
		mergeSort(arr,temp,l,m);
		mergeSort(arr,temp,m+1,r);
		merge(arr,temp,l,m,r);
		}
	}

	private static void merge(int[] arr,int[] temp,int l,int m,int r){
		int i = l;
		int j = m;
		while(i<m && j<r)
			if(arr[i]<=arr[j]) temp[i] = arr[i++];
			else temp[j] = arr[j++];
		while(i<m)
			if(arr[i]<=arr[j]) temp[i] = arr[i++];
		while(j<r)
			if(arr[i]<=arr[j]) temp[j] = arr[j++];

	}

	public static void main(String[] args){
		int[] arr = new int[1000];
		for(int i=0;i<arr.length;i++)
			arr[i] = ThreadLocalRandom.current().nextInt(1,100);
		sort(arr);
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]);
	}

}
