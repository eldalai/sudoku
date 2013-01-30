package com.gl.exercice.sudoku;

public class SudokuResolver {

	public static SudokuBoard resolve(String init) {
		init = init.replaceAll("x", "0");
		SudokuBoard board = new SudokuBoard(init);
		return board;
	}

}
