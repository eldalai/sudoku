package com.gl.exercice.sudoku.test;

import com.gl.exercice.sudoku.SudokuBoard;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestBoard extends TestCase {

	    /**
	     * Test a Valid Sudoku Board
	     */
	    public void testValidSudokuBoard()
	    {
	    	try {
	    		SudokuBoard board = new SudokuBoard(
		    			"534678912" +
		    			"672195348" +
		    			"198342567" +
		    			"859761423" +
		    			"426853791" +
		    			"713924856" +
		    			"961537284" +
		    			"287419635" +
		    			"345286179");
		        assertTrue( board.isValid() );
		        assertTrue( board.isColsValid() );
		        assertTrue( board.isFilsValid() );
		        assertTrue( board.isSectorsValid() );
			} catch (Exception e) {
				fail( "i'm not expecting to get an exception" );
				e.printStackTrace();
			}
	    }

	    /**
	     * Test a invalid col Sudoku Board
	     */
	    public void testInvalidColSudokuBoard()
	    {
	    	try {
		    	SudokuBoard board = new SudokuBoard(
		    			"534678912" + // invalid col 1
		    			"572195348" + // invalid col 1
		    			"198342567" +
		    			"859761423" +
		    			"426853791" +
		    			"713924856" +
		    			"961537284" +
		    			"287419635" +
		    			"345286179");
		        assertFalse( board.isValid() );
		        assertFalse( board.isColsValid() );
	
		    	board = new SudokuBoard(
		    			"534678912" +
		    			"672195348" + // invalid col 3
		    			"198342567" +
		    			"852761423" + // invalid col 3
		    			"426853791" +
		    			"713924856" +
		    			"961537284" +
		    			"287419635" +
		    			"345286179");
		        assertFalse( board.isValid() );
		        assertFalse( board.isColsValid() );
	
		        board = new SudokuBoard(
		    			"534678912" +
		    			"672195348" +
		    			"198342567" +
		    			"859761423" +
		    			"426853791" +
		    			"713924856" + // invalid col 9
		    			"961537284" +
		    			"287419636" + // invalid col 9
		    			"345286179");
		        assertFalse( board.isValid() );
		        assertFalse( board.isColsValid() );
			} catch (Exception e) {
				fail( "i'm not expecting to get an exception" );
				e.printStackTrace();
			}
	    }

	    /**
	     * Test a invalid fil Sudoku Board
	     */
	    public void testInvalidFilSudokuBoard() {
	    	try {	
		    	SudokuBoard board = new SudokuBoard(
		    			"554678912" + // invalid fil
		    			"672195348" +
		    			"198342567" +
		    			"859761423" +
		    			"426853791" +
		    			"713924856" +
		    			"961537284" +
		    			"287419635" +
		    			"345286179");
		        assertFalse( board.isValid() );
		        assertFalse( board.isFilsValid() );
		    	
		    	board = new SudokuBoard(
		    			"534678912" +
		    			"672195348" +
		    			"198342567" +
		    			"859761423" +
		    			"426853791" +
		    			"713927856" + // invalid fil
		    			"961537284" +
		    			"287419635" +
		    			"345286179");
		        assertFalse( board.isValid() );
		        assertFalse( board.isFilsValid() );
		        
		        board = new SudokuBoard(
		    			"534678912" +
		    			"672195348" +
		    			"198342567" +
		    			"859761423" +
		    			"426853791" +
		    			"713924856" +
		    			"961537284" +
		    			"287419635" +
		    			"345286199"); // invalid fil
		        assertFalse( board.isValid() );
		        assertFalse( board.isFilsValid() );
			} catch (Exception e) {
				fail( "i'm not expecting to get an exception" );
				e.printStackTrace();
			}

	    }

	    /**
	     * Test a invalid sector Sudoku Board
	     */
	    public void testInvalidSectorSudokuBoard()
	    {
	    	try {
	    		SudokuBoard board = new SudokuBoard(
		    			"534678912" + // 5 invalid
		    			"652195348" + // 5 invalid
		    			"198342567" +
		    			"859761423" +
		    			"426853791" +
		    			"713924856" +
		    			"961537284" +
		    			"287419635" +
		    			"345286179");
		        assertFalse( board.isValid() );
		        assertFalse( board.isSectorsValid() );
		    	board = new SudokuBoard(
		    			"534678912" +
		    			"672195348" +
		    			"198342567" +
		    			"859761423" + // 7 is invalid in sector
		    			"426857791" + // 7 is invalid in sector
		    			"713924856" +
		    			"961537284" +
		    			"287419635" +
		    			"345286179");
		        assertFalse( board.isValid() );
		        assertFalse( board.isSectorsValid() );
			} catch (Exception e) {
				fail( "i'm not expecting to get an exception" );
				e.printStackTrace();
			}

	    }

	    /**
	     * Test a invalid sector Sudoku Board
	     */
	    public void testWrongSudokuBoard()
	    {
	    	try {
	    		SudokuBoard board = new SudokuBoard(
		    			"534678912" + // this is wrong!
		    			"345286179");
	    		fail( "i'm expecting to get an exception" );
			} catch (Exception e) {
				e.printStackTrace();
			}

	    }

}
