package com.gl.exercice.sudoku;

public class SudokuBoard {

	public static final int MAX_LENGHT = 9;
	private int[][] board ;

	/**
	 * Create a Sudoku Board
	 * @param board: simple 9 x 9 character string
	 */
	public SudokuBoard( String initialBoard ) {
		super();
		board = new int[MAX_LENGHT][MAX_LENGHT];

		int x1 = 0;
		int number;
		for( int fil = 0; fil <= (MAX_LENGHT - 1); fil++ )
			for( int col = 0; col <= (MAX_LENGHT - 1); col++ ) {
				number = Integer.parseInt( initialBoard.substring( x1, x1+1 ) );
				board[fil][col] = number; 
				x1++;
			}

	}

	/**
	 * @return board as simple 9 x 9 character string
	 */
	public String toString() {
		StringBuffer str = new StringBuffer();
		for( int fil = 0; fil <= (MAX_LENGHT - 1); fil++ )
			for( int col = 0; col <= (MAX_LENGHT - 1); col++ ) {
				str.append( board[fil][col] );
			}
		return str.toString();
	}

	/**
	 * valid Board
	 * @return true is valid fils, cols & sectors  
	 */
	public boolean isValid() {
		return isColsValid() && isFilsValid() && isSectorsValid();
	}
	
	/**
	 * valid cols Board
	 * @return true is valid cols  
	 */
	public boolean isColsValid() {
		int [] ctl = new int[10];
		for( int col = 0; col <= (MAX_LENGHT - 1); col++ ){
			cleanControl(ctl);
			for( int fil = 0; fil <= (MAX_LENGHT - 1); fil++ ){
				if( board[fil][col] != 0 )
				{	
					ctl[ board[fil][col] ]++;
					if(ctl[ board[fil][col] ]>1) {
						System.out.println("Ctrl x col: Invalid in:"+fil+" col:"+col+" num:"+board[fil][col]);
						return false;
					}
				}
			}
		}
		return true;
	}		
	
	/**
	 * valid fils Board
	 * @return true is valid fils  
	 */
	public boolean isFilsValid() {
		int [] ctl = new int[10];
		for( int fil = 0; fil <= (MAX_LENGHT - 1); fil++ ){
			cleanControl(ctl);
			for( int col = 0; col <= (MAX_LENGHT - 1); col++ ){
				if( board[fil][col] != 0 )
				{	
					ctl[ board[fil][col] ]++;
					if(ctl[ board[fil][col] ]>1) {
						System.out.println("Ctrl x fil: Invalid in fil:"+fil+" col:"+col+" num:"+board[fil][col]);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * valid sectors Board
	 * @return true is valid sectors  
	 */
	public boolean isSectorsValid() {
		int [] ctl = new int[10];
		
		for( int col = 0; col < 3; col++ ){
			for( int fil = 0; fil < 3; fil++ ){
				cleanControl(ctl);
				for( int icol = 0; icol < 3; icol++ ) {
					for( int ifil = 0; ifil < 3; ifil++ ) {
						if( board[fil*3+ifil][col*3+icol] != 0 )
						{	
							ctl[ board[fil*3+ifil][col*3+icol] ]++;
							if(ctl[ board[fil*3+ifil][col*3+icol] ]>1) {
								System.out.println("Ctrl x sector: Invalid in fil:"+fil+" col:"+col+" num:"+board[fil*3+ifil][col*3+icol] );
								return false;
							}
							
						}
					}
				}
			}
		}
		
		return true;
	}

	private void cleanControl(int[] ctl) {
		for( int clean = 0; clean <= MAX_LENGHT; clean++ ) ctl[clean]=0;
	}

	public int getCell(int fil, int col) {
		return board[fil][col];
	}

	public void setCell(int fil, int col, int candidate) {
		board[fil][col] = candidate;
	}
	
}
