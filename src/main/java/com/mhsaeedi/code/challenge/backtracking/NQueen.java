package com.mhsaeedi.code.challenge.backtracking;

import static com.mhsaeedi.code.challenge.backtracking.QueenSafeCheck.isSafe;

public class NQueen{

	private static boolean solve(int[][] arr, int col){
		if(col >= arr.length) return true;
		for(int row=0 ; row < arr.length ; row++){
			if(isSafe(arr,row, col)) {
				arr[row][col] = 1;
				if(solve(arr,col+1))
					return true;
				arr[row][col] = 0;
			}
		}
		return false;
	}

	public static boolean solve(int[][] arr)
	{
		return arr.length >= 4 && solve(arr, 0);
	}




}
