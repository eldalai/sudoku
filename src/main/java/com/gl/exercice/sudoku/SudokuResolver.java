package com.gl.exercice.sudoku;

public class SudokuResolver {

	public static SudokuBoard resolve(String init) {
		SudokuBoard board = new SudokuBoard(init);
		return board;
	}

}
