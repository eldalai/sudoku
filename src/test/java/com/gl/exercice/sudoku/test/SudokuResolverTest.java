package com.gl.exercice.sudoku.test;

import com.gl.exercice.sudoku.SudokuBoard;
import com.gl.exercice.sudoku.SudokuResolver;

import junit.framework.Test;
import junit.framework.TestCase;

public class SudokuResolverTest extends TestCase {

    /**
     * Test Sudoku Resolver Board... valid filled sudoku 
     */
    public void testDummySudokuResolverBoard()
    {
    	String init = 
    		"534678912" +
    		"672195348" +
    		"198342567" +
    		"859761423" +
    		"426853791" +
    		"713924856" +
    		"961537284" +
    		"287419635" +
    		"345286179";
    	SudokuBoard board = SudokuResolver.resolve( init );
    	assertEquals(board.toString(), init);
    	assertTrue(board.isValid());
    }
    public void testDummyWithXSudokuResolverBoard()
    {
    	String init = 
    		"x34678912" +
    		"672195348" +
    		"198342567" +
    		"859761423" +
    		"426853791" +
    		"713924856" +
    		"961537284" +
    		"287419635" +
    		"345286179";
    	SudokuBoard board = SudokuResolver.resolve( init );
    	assertTrue(board.isValid());
    }
}
