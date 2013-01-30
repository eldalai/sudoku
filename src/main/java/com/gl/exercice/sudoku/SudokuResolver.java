package com.gl.exercice.sudoku;

public class SudokuResolver {

	/**
	 * resolve a Sudoku
	 * @return an valid & resolved sudoku board  
	 * @throws Exception 
	 */
	public static SudokuBoard resolve(String init) throws Exception {
		init = init.replaceAll("x", "0");
		SudokuBoard board = new SudokuBoard(init);
		if( !board.isValid() )
			throw new Exception("The board is not valid, give me a break!");
		
		think(board, 0, 0);
		
		return board;
	}

	
	/**
	 * think about posible answers... 
	 * @return true if it's resolved! false... should think better!  
	 */
	private static boolean think(SudokuBoard board, int fil, int col) {
		// the big end! return true to close the recursion
		if( fil == SudokuBoard.MAX_LENGHT  )
			return true;
		
		// if is not empty, go on with others cells....
		if( board.getCell( fil, col ) != 0 )
			return goOn( board, fil, col );
		
		// try with all candidate numbers
		for( int candidate = 1; candidate <= 9; candidate++ ) {
			// set the board with the candidate...
			board.setCell( fil, col, candidate );
			// if it is valid... onGo! THink another cell
			if( board.isValid() ) {
				if( goOn( board, fil, col ) )
				{	
					return true;
				}
			}	
		}
		// if wrong, go back to cero... other recursion gonna think better...
		board.setCell( fil, col, 0 );
		return false;
		
	}

	private static boolean goOn(SudokuBoard board, int fil, int col) {
		if( col == SudokuBoard.MAX_LENGHT - 1 )
			return think( board, fil + 1, 0 );
		else
			return think( board, fil, col + 1 );
	}

}
