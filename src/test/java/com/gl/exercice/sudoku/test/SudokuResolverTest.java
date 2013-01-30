package com.gl.exercice.sudoku.test;

import java.util.Date;

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
    	SudokuBoard board;
		try {
			board = SudokuResolver.resolve( init );
			assertEquals(board.toString(), init);
			assertTrue(board.isValid());
		} catch (Exception e) {
			fail( "i'm not expecting to get an exception" );

		}
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
    	try {
    		SudokuBoard board = SudokuResolver.resolve( init );
			assertTrue(board.isValid());
		} catch (Exception e) {
			e.printStackTrace();
			fail( "i'm not expecting to get an exception" );
		}
    }
    public void testSimpleSudokuResolverBoard()
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
    	String expected = 
    		"534678912" +
    		"672195348" +
    		"198342567" +
    		"859761423" +
    		"426853791" +
    		"713924856" +
    		"961537284" +
    		"287419635" +
    		"345286179";
    	SudokuBoard board;
		try {
			board = SudokuResolver.resolve( init );
			assertTrue(board.isValid());
			assertEquals(expected, board.toString());
		} catch (Exception e) {
			e.printStackTrace();
			fail( "i'm not expecting to get an exception" );
		}
    }
    public void testComplexSudokuResolverBoard()
    {
    	String init = 
    		"53xx7xxxx" +
    		"6xx195xxx" +
    		"x98xxxx6x" +
    		"8xxx6xxx3" +
    		"4xx8x3xx1" +
    		"7xxx2xxx6" +
    		"x6xxxx28x" +
    		"xxx419xx5" +
    		"xxxx8xx79";
    	String expected = 
    		"534678912" +
    		"672195348" +
    		"198342567" +
    		"859761423" +
    		"426853791" +
    		"713924856" +
    		"961537284" +
    		"287419635" +
    		"345286179";
    	
    	try {
    		SudokuBoard board = SudokuResolver.resolve( init );
	    	assertEquals(expected, board.toString());
	    	assertTrue(board.isValid());
		} catch (Exception e) {
			e.printStackTrace();
			fail( "i'm not expecting to get an exception" );
		}
    }

    public void testOtherComplexSudokuResolverBoard()
    {
    	String init = 
    		"xxx894xxx" +
    		"843x6x1xx" +
    		"72xx13xx6" +
    		"4xx9xx6xx" +
    		"xxx6xx75x" +
    		"xxxx78xxx" +
    		"x5xxxx84x" +
    		"xxx14xxxx" +
    		"6xx7xx5x3";
    	String expected = 
    		"165894372" +
    		"843267195" +
    		"729513486" +
    		"471952638" +
    		"298631754" +
    		"536478219" +
    		"957326841" +
    		"382145967" +
    		"614789523";
    	
    	try {
	    	Date now = new Date();
	    	SudokuBoard board = SudokuResolver.resolve( init );
	    	Date end = new Date();
	    	long takes = end.getTime() - now.getTime();
	    	System.out.println( "resolved takes: " + takes + " miliseconds " );
	    	System.out.println( board.toString() );
	    	assertEquals(expected, board.toString());
	    	assertTrue(board.isValid());
		} catch (Exception e) {
			e.printStackTrace();
			fail( "i'm not expecting to get an exception" );
		}
    }


    public void testWrongSudokuResolverBoard()
    {
    	String init = 
    		"xxx844xxx" + // wrong! 
    		"843x6x1xx" +
    		"72xx13xx6" +
    		"4xx9xx6xx" +
    		"xxx6xx75x" +
    		"xxxx78xxx" +
    		"x5xxxx84x" +
    		"xxx14xxxx" +
    		"6xx7xx5x3";
    	
    	try {
	    	SudokuBoard board = SudokuResolver.resolve( init );
	    	fail( "i'm expecting to get an exception" );
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
