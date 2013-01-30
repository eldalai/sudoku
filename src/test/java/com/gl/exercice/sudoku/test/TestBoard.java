package com.gl.exercice.sudoku.test;

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
	     * Rigourous Test :-)
	     */
	    public void testApp()
	    {
	        assertTrue( true );
	    }
	}
