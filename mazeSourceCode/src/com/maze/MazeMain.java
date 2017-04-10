package com.maze;

public class MazeMain {

	public static void main(String[] args) {
		//Check arguments
		if (!(args.length>0)) {
			System.out.println("Program requires file name as an argument");
			return;
		}

		//Read Maze from file into Maze object
		MazeReaderWriter mrw = new MazeReaderWriterImpl();
		Maze mazeMap = mrw.readMazeFromFile(args[0]);

		//Find solution to maze
		MazeSolver mazeSoler = new MazeSolverImpl();
		boolean mazeResolved = mazeSoler.run(mazeMap);

		//Print Maze with solution to the screen
		mrw.writeMazeToConsole(mazeMap, mazeResolved);
	}

}
