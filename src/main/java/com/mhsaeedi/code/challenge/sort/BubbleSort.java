package com.mhsaeedi.code.challenge.sort;

/**
 * @author : Momo
 * @since : 28.02.22, Mon
 **/
public class BubbleSort
{
	public static void sort(int[] arr){
		for(int i = 0; i<arr.length-1;i++){
			for(int j=0; j< arr.length-1;j++)
				if(arr[j]>arr[j+1]) swap(arr,j,j+1);
		}
	}

	private static void swap(int[] arr,int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args){
		int[] arr = new int[]{0,-1,-2};
		sort(arr);
		for(int i = 0 ; i<arr.length ; i++)
			System.out.println(arr[i]);
	}
}
