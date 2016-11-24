package com.ibm.gol;

public class Grid {
	
	private boolean[][] grid;
	
	public Grid(){
		grid = new boolean[getXDimension()][getYDimension()];
		grid[1][4] = true;
		grid[2][3] = true;
		grid[2][4] = true;
	}

	public int getXDimension() {
		return 4;
	}

	public int getYDimension() {
		return 8;
	}

	public boolean isAlive(int x, int y) {
		return grid[x][y];
	}
	
	public String toString(){
		StringBuffer output = new StringBuffer();
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[0].length; y++) {
				output.append(grid[x][y] ? "*" :  ".");
			}
			output.append("\n");
		}
		return output.toString();
	}

	public int countAliveNeighbours(int x, int y) {
		int counter = 0;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i == x && j == y) continue;
				try{
					if(grid[i][j]) counter++;
				}catch(ArrayIndexOutOfBoundsException e){}
			}
		}
		return counter;
	}

	public boolean isAliveInNextGeneration(int x, int y) {
//		   1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
//		   2. Any live cell with more than three live neighbours dies, as if by overcrowding.
//		   3. Any live cell with two or three live neighbours lives on to the next generation.
//		   4. Any dead cell with exactly three live neighbours becomes a live cell.
		int aliveNeighbours = countAliveNeighbours(x, y);
		if(aliveNeighbours < 2 ) return false;
		if(aliveNeighbours > 3) return false;
		if(grid[x][y] == false && aliveNeighbours == 3) return true;
		return grid[x][y];
	}

	public void calculateNextGeneration() {
		boolean[][] tempGrid = new boolean[getXDimension()][getYDimension()];
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if(isAliveInNextGeneration(x, y)) tempGrid[x][y] = true;
			}
		}
		grid = tempGrid;
	}

}
