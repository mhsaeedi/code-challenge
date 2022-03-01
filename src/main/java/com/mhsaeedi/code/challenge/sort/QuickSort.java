package com.mhsaeedi.code.challenge.sort;

import java.util.concurrent.ThreadLocalRandom;

import com.mhsaeedi.code.challenge.datastructure.filo.Filo;

/**
 * @author : Momo
 * @since : 28.02.22, Mon
 **/
public class QuickSort
{

	private static int partition(int[] arr, int l, int r){
		for(int j = l;j<r;j++) if(arr[j]<=arr[r]) swap(arr,j,l++);
		swap(arr,r,l);
		return l;
	}

	private static void swap(int[] arr, int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args){
		int[] arr = new int[1000];

		for(int i=0;i<1000;i++){
			arr[i] = ThreadLocalRandom.current().nextInt(1,100);
		}
		sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+", ");
		}
	}

	public static void sort(int[] arr){
		Filo<Integer> stack = new Filo<>();
		stack.push(0);
		stack.push(arr.length - 1);

		while(!stack.isEmpty()){
			int r = stack.pop();
			int l = stack.pop();
			int pivot = partition(arr,l,r);
			if(pivot-1>l) {
				stack.push(l);
				stack.push(pivot-1);
			}
			if(pivot+1<r){
				stack.push(pivot+1);
				stack.push(r);
			}
		}

	}
}
