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
	     * Create the test case
	     *
	     * @param testName name of the test case
	     */
	    public TestBoard( String testName )
	    {
	        super( testName );
	    }

	    /**
	     * @return the suite of tests being tested
	     */
	    public static Test suite()
	    {
	        return new TestSuite( TestBoard.class );
	    }

	    /**
	     * Test a Valid Sudoku Board
	     */
	    public void testValidSudokuBoard()
	    {
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
	    }

	    /**
	     * Test a invalid col Sudoku Board
	     */
	    public void testInvalidColSudokuBoard()
	    {
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
	    }

	    /**
	     * Test a invalid fil Sudoku Board
	     */
	    public void testInvalidFilSudokuBoard() {
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
	    }

	    /**
	     * Test a invalid sector Sudoku Board
	     */
	    public void testInvalidSectorSudokuBoard()
	    {
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
	    }
}
