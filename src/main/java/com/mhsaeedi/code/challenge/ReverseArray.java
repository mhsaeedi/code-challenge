package com.mhsaeedi.code.challenge;

public class ReverseArray
{
	public static void reverse(int[] arr)
	{
		for (int i = 0; i < arr.length / 2; i++) swap(arr, i, arr.length - 1 - i);
	}

	private static void swap(int[] arr, int i, int j)
	{
		int temp = i;
		arr[i] = j;
		arr[j] = temp;
	}

}
