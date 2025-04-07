# Sudoku Solver Challenge

This is a simple Sudoku solver that takes a hardcoded unsolved puzzle and prints the solved Sudoku grid to the console.

## How It Works

- You can input a custom Sudoku puzzle by modifying the `loadedSudoku` matrix in the `Sudoku` class.
- It uses a backtracking algorithm to find a valid solution.
- Once solved, the completed grid is printed to the console.


## Requirements

- Java
- No external libraries required  

## Example

### Unsolved sudoku:

```
+-------+-------+-------+
|   2   |     7 | 8 3   |
| 7     |       | 9     |
|   6   |   5 8 | 4     |
+-------+-------+-------+
|     3 |       | 2 8   |
| 9     | 1   5 |     7 |
|   7 5 |       | 6     |
+-------+-------+-------+
|     6 | 5 2   |   9   |
|     7 |       |     8 |
|   9 1 | 7     |   2   |
+-------+-------+-------+

```

### Solved sudoku:
```
+-------+-------+-------+
| 5 2 4 | 6 9 7 | 8 3 1 |
| 7 3 8 | 2 1 4 | 9 5 6 |
| 1 6 9 | 3 5 8 | 4 7 2 |
+-------+-------+-------+
| 6 1 3 | 4 7 9 | 2 8 5 |
| 9 8 2 | 1 6 5 | 3 4 7 |
| 4 7 5 | 8 3 2 | 6 1 9 |
+-------+-------+-------+
| 8 4 6 | 5 2 1 | 7 9 3 |
| 2 5 7 | 9 4 3 | 1 6 8 |
| 3 9 1 | 7 8 6 | 5 2 4 |
+-------+-------+-------+
```

