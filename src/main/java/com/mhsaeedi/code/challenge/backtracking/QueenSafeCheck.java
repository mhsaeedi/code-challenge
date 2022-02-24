package com.mhsaeedi.code.challenge.backtracking;

/**
 * @author : Momo
 * @since : 15.02.22, Tue
 **/
public class QueenSafeCheck
{
	protected static boolean isSafe(int[][] arr, int row, int col){
		return  isSafeRow(arr,row,col) &&
			isSafeDiagonalTopLeft(arr,row,col) &&
			isSafeDiagonalBottomLeft(arr,row,col);
	}

	private static boolean isSafeRow(int[][] arr, int row,int col){
		while(col > 0){
			col = col -1;
			if(arr[row][col] == 1) return false;
		}
		return true;
	}

	private static boolean isSafeDiagonalTopLeft(int[][] arr, int row, int col){
		while(row > 0 && col > 0){
			col = col - 1;
			row = row - 1;
			if(arr[row][col] == 1) return false;
		}
		return true;
	}

	private static boolean isSafeDiagonalBottomLeft(int[][] arr, int row, int col){
		while(row < arr.length-1 && col > 0){
			row = row + 1;
			col = col - 1;
			if(arr[row][col] == 1) return false;
		}
		return true;
	}
}
