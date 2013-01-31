package com.gl.exercice.sudoku;

import java.io.IOException;
import java.util.Scanner;

public class SudokuResolverInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Sudoku Resolver!");
		System.out.println("Please enter the 9 lines of the problem");
		System.out.println("Each line have to have 9 numbers from 1 to 9");
		System.out.println("or  \"x\" for the unknowns numbers.");
	    Scanner scanner = new Scanner(System.in);
	    String line;
	    StringBuffer buffer = new StringBuffer();
	    for(int lines=1; lines <=9;lines++) {
	    	System.out.print("Enter Line " + lines + ":");
	    	line = scanner.nextLine();
	    	while( !isValid(line) )
	    	{	
		    	System.out.print("Enter Line " + lines + ":");
		    	line = scanner.nextLine();
	    	}
	    	buffer.append(line);
	    }
		try {
	    	
			SudokuBoard resolvedSudoku = SudokuResolver.resolve(buffer.toString());
			System.out.println("Your answer is:	");
			System.out.println(resolvedSudoku.toStringWithEOL());
		} catch (Exception e) {
			System.out.println("i'm sorry, your board is incorrect");	
		}
		System.out.println("Press enter to exit, thanks for play!");
		scanner.nextLine();
	}

	private static boolean isValid(String line) {
		if(line.length() != 9)
		{
			System.out.println("Please enter a 9 numbers o an \"x\"");
			return false;
		}
		return true;
	}
}
