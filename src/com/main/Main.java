package com.main;

import com.sudoku.Sudoku;

public class Main {

	public static void main(String[] args) {
		
		Sudoku.createSukokuGrid();
		
		Sudoku.printGrid();

		Sudoku.solve();
		
		Sudoku.printGrid();
		
		
	}

}
