package com.mhsaeedi.code.challenge.backtracking;

/**
 * @author : Momo
 * @since : 15.02.22, Tue
 **/
public class BoardBuilder
{
	protected static int[][] buildBoard(int size)
	{
		int[][] board = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) board[i][j] = 0;
		return board;
	}
}
