package com.maze;

interface MazeReaderWriter {

	Maze readMazeFromFile(String filename);
	void writeMazeToConsole(Maze maze, boolean mazeResolved);

}
