# Sudoku Solver Challenge

This is a simple Sudoku solver that takes a hardcoded unsolved puzzle and prints the solved Sudoku grid to the console.

## How It Works

- You can input a custom Sudoku puzzle by modifying the `loadedSudoku` matrix in the `Sudoku` class.
- It uses a backtracking algorithm to find a valid solution.
- Once solved, the completed grid is printed to the console.


### Notes
- The numbers `0` in the unsolved Sudoku represent empty cells.
- The solver fills in these empty cells to generate a valid completed Sudoku grid.

## Requirements

- Java
- No external libraries required  

## Example

### Unsolved sudoku:

```
-----------
004|800|602
950|007|843
830|492|050
-----------
601|039|470
080|240|309
340|008|020
-----------
217|304|960
503|760|080
060|025|031
-----------

```

### Solved sudoku:
```
-----------
174|853|692
952|617|843
836|492|157
-----------
621|539|478
785|246|319
349|178|526
-----------
217|384|965
593|761|284
468|925|731
-----------
```

