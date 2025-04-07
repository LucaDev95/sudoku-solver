package com.sudoku;

public class Sudoku {

	private final int[][] grid;
	
	private final int[] actionArray;
	
	private final int[][] actionRowCol;

	private static Sudoku sudoku;

	private Sudoku(){
		 grid =new int[][] { { 0, 0, 4, 8, 0, 0, 6, 0, 2 },
				{ 9, 5, 0, 0, 0, 7, 8, 4, 3 },
				{ 8, 3, 0, 4, 9, 2, 0, 5, 0 },

				{ 6, 0, 1, 0, 3, 9, 4, 7, 0 },
				{ 0, 8, 0, 2, 4, 0, 3, 0, 9 },
				{ 3, 4, 0, 0, 0, 8, 0, 2, 0 },

				{ 2, 1, 7, 3, 0, 4, 9, 6, 0 },
				{ 5, 0, 3, 7, 6, 0, 0, 8, 0 },
				{ 0, 6, 0, 0, 2, 5, 0, 3, 1 } };

		actionArray=new int[81];
		actionRowCol=new int[81][2];
	}

	public static Sudoku getSudokuGrid(){
		if(sudoku==null){
			sudoku=new Sudoku();
		}
		return sudoku;
	}


	public void printGrid() {

		for (int posRow = 0; posRow < 9; posRow++) {
			if (posRow%3==0) {
				System.out.println("+-------+-------+-------+");
			}
			for (int posCol = 0; posCol < 9; posCol++) {
				if (posCol%3==0) {
					System.out.print("| ");
				}
				int value=grid[posRow][posCol];
				System.out.print(value!=0?value+" ":"  ");
			}
			System.out.println("|");
		}
		System.out.println("+-------+-------+-------+");
		
		
	}

	private boolean checkBlock(int num, int numBlock) {
		int rowStart = (numBlock / 3) * 3;
		int colStart = (numBlock % 3) * 3;

		for (int i = colStart; i < colStart + 3; i++) {
			if (grid[rowStart][i] == num || grid[rowStart + 1][i] == num || grid[rowStart + 2][i] == num) {
				return true;
			}
		}
		return false;
	}

	private boolean notInRow(int num, int numRow) {
		for (int i = 0; i < 9; i++) {
			if (grid[numRow][i] == num) {
				return false;
			}
		}
		return true;
	}

	private boolean notInColumn(int num, int numCol) {
		for (int i = 0; i < 9; i++) {
			if (grid[i][numCol] == num) {
				return false;
			}
		}
		return true;
	}


	private void delete(int numRow, int numCol) {
		grid[numRow][numCol] = 0;
	}
	
	private int[] firstAvailable(int num,int block) {
		int rowStart = (block / 3) * 3;
		int colStart = (block % 3) * 3;

		
		for(int i=colStart;i<colStart+3;i++) {
			if(grid[rowStart][i]==0) {
				if(notInRow(num,rowStart) && notInColumn(num,i)) {
					return new int[]{rowStart,i};
				}
			}
		}
		
		for(int i=colStart;i<colStart+3;i++) {
			if(grid[rowStart+1][i]==0) {
				if(notInRow(num,rowStart+1) && notInColumn(num,i)) {
					return new int[]{rowStart+1,i};
				}
			}
		}
		
		for(int i=colStart;i<colStart+3;i++) {
			if(grid[rowStart+2][i]==0) {
				if(notInRow(num,rowStart+2) && notInColumn(num,i)) {
					return new int[]{rowStart+2,i};
				}
			}
		}
		
		return null;
	}
	
	private int[] firstFromPos(int num,int block,int row, int col) {
		int rowStart = (block / 3) * 3;
		int colStart = (block % 3) * 3;
		
		int diffRow=row-rowStart;
		int diffCol=col-colStart;
		
		
		if(diffRow==2 && diffCol==2) {
			return null;
		}else if(diffCol==2) {
			diffRow++;
			diffCol=0;
		}else {
			diffCol++;
		}
		

		if(diffRow==0) {
			for(int i=colStart+diffCol;i<colStart+3;i++) {
				if(grid[rowStart][i]==0) {
					if(notInRow(num,rowStart) && notInColumn(num,i)) {
						return new int[]{rowStart,i};
					}
				}
			}
		}
		

		
		if(diffRow==0) {
			for(int i=colStart;i<colStart+3;i++) {
				if(grid[rowStart+1][i]==0) {
					if(notInRow(num,rowStart+1) && notInColumn(num,i)) {
						return new int[]{rowStart+1,i};
					}
				}
			}
		}else if(diffRow==1) {
			for(int i=colStart+diffCol;i<colStart+3;i++) {
				if(grid[rowStart+1][i]==0) {
					if(notInRow(num,rowStart+1) && notInColumn(num,i)) {
						return new int[]{rowStart+1,i};
					}
				}
			}
		}
		
		if(diffRow<2) {
			for(int i=colStart;i<colStart+3;i++) {
				if(grid[rowStart+2][i]==0) {
					if(notInRow(num,rowStart+2) && notInColumn(num,i)) {
						return new int[]{rowStart+2,i};
					}
				}
			}
		}else {
			for(int i=colStart+diffCol;i<colStart+3;i++) {
				if(grid[rowStart+2][i]==0) {
					if(notInRow(num,rowStart+2) && notInColumn(num,i)) {
						return new int[]{rowStart+2,i};
					}
				}
			}
		}
		
		
		return null;
	}

	public void solve() {
		int i=0;
		boolean forward=true;
		while(i<81) {
			int num=i/9 +1;
			int block = i%9;
			
			if(forward) {
				if(!checkBlock(num,block)) {
					int[] arr=firstAvailable(num,block);
					if(arr==null) {
						forward=false;
						i--;
					}else {
						grid[arr[0]][arr[1]]=num;
						actionArray[i]=num;
						actionRowCol[i][0]=arr[0];
						actionRowCol[i][1]=arr[1];
						i++;

					}
					
				}else {
					actionArray[i]=0;
					actionRowCol[i][0]=0;
					actionRowCol[i][1]=0;
					i++;
				}
				
			}else {
				int toRemove=actionArray[i];
				if(toRemove==0) {
					i--;
				}else {
					

					int rowRemove=actionRowCol[i][0];
					int colRemove=actionRowCol[i][1];
					actionRowCol[i][0]=0;
					actionRowCol[i][1]=0;
					
					delete(rowRemove,colRemove);
					actionArray[i]=0;

					int[] arr=firstFromPos(num,block,rowRemove,colRemove);
					if(arr==null) {
						i--;
					}else {
						grid[arr[0]][arr[1]]=num;
						
						actionArray[i]=num;
						actionRowCol[i][0]=arr[0];
						actionRowCol[i][1]=arr[1];
						forward=true;
						i++;

					}
					
				}
			}
			
		}
	}


	
}
