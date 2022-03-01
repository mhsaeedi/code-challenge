package com.mhsaeedi.code.challenge.sort;

/**
 * @author : Momo
 * @since : 28.02.22, Mon
 **/
public class SelectionSort
{
	public static void sort(int[] arr){
		int min;
		for(int i=0;i<arr.length-1;i++){
			min = i;
			for(int j=i+1;j<arr.length;j++)
				if(arr[j] < arr[i]) min = j;
			swap(arr,i,min);
		}
	}

	private static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args){
		int[] arr = new int[]{6,5,4};
		sort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}

}
