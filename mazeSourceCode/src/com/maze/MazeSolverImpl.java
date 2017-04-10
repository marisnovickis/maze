package com.maze;

public class MazeSolverImpl implements MazeSolver {

	private int[][] mazeArray;
	static boolean solutionFound = false;

	@Override
	public boolean run(Maze maze) {
		mazeArray = maze.getMazeArray();
		boolean mazeResolved = recursiveRun(maze.getStartY(), maze.getStartX(), 1);
		mazeArray[maze.getStartY()][maze.getStartX()] =- 1; //indicating starting position
		return mazeResolved;

	}

	/*
	 * x,y - the current position in the map viewed by algorithm
	 * return
	 *  boolean - true if solution has been found, false no solution in this recursive branch
	 * */
	private boolean recursiveRun(int y, int x, int stepCount) {
		// We found solution and need to return it back
		if (mazeArray[y][x]==-2 ) {
			//mark maze position and indicate that we found solution
			return true;
		}

		//mark maze position to prevent going back and forward
		mazeArray[y][x] = stepCount;

		// We still looking for solution
		if ((mazeArray[y+1][x] == 0 || mazeArray[y+1][x] == -2) && !solutionFound) { // Move Down
			solutionFound = recursiveRun( y+1, x, stepCount+1);
		}
		if ((mazeArray[y][x-1] == 0 || mazeArray[y][x-1] == -2) && !solutionFound) { // Move Left
			solutionFound = recursiveRun( y, x-1, stepCount+1);
		}
		if ((mazeArray[y-1][x] == 0 || mazeArray[y-1][x] == -2) && !solutionFound) { // Move Up
			solutionFound = recursiveRun( y-1, x, stepCount+1);
		}
		if ((mazeArray[y][x+1] == 0 || mazeArray[y][x+1] == -2) && !solutionFound) { // Move Right
			solutionFound = recursiveRun( y, x+1, stepCount+1);
		}

		if (solutionFound) { //mark maze position and indicate that we found solution
			mazeArray[y][x] = -3;
		}
		return solutionFound;
	}
}
