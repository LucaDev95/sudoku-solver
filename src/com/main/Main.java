package com.main;

import com.sudoku.Sudoku;

public class Main {

    public static void main(String[] args) {

        try {

            Sudoku sudoku = Sudoku.getSudokuGrid();

            sudoku.printGrid();

            sudoku.solve();

            sudoku.printGrid();

        } catch (RuntimeException e) {
            System.out.println("Invalid sudoku");
        }

    }

}
