package com.maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class MazeReaderWriterImpl implements MazeReaderWriter{
	private int lineNumber=1;
	int[][] mazeArray;

	@Override
	public Maze readMazeFromFile(String filename) {
		Maze maze = new Maze();

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {

			stream.forEach(line -> {
				String[] tokens = line.split(" ");
				switch (lineNumber) {
					case 1:
						maze.setHeight(Integer.parseInt(tokens[1]));
						maze.setWidth(Integer.parseInt(tokens[0]));
						mazeArray = new int[maze.getHeight()][maze.getWidth()];
						break;
					case 2:
						maze.setStartX(Integer.parseInt(tokens[0]));
						maze.setStartY(Integer.parseInt(tokens[1]));
						break;
					case 3:
						maze.setEndX(Integer.parseInt(tokens[0]));
						maze.setEndY(Integer.parseInt(tokens[1]));
						break;
					default: //lets build the mazeMap
						int index = 0;
						for (String s: tokens) {
							int cell = Integer.parseInt(s);
							mazeArray[lineNumber-4][index]= cell;
							index++;
						}
						break;
				}
				lineNumber++;
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		mazeArray[maze.getEndY()][maze.getEndX()] = -2;
		maze.setMazeArray(mazeArray);
		return maze;
	}

	@Override
	public void writeMazeToConsole(Maze maze, boolean mazeResolved) {
		System.out.println("OUTPUT:");
		StringBuilder sb = new StringBuilder();
		int[][] mazeArray =  maze.getMazeArray();
		for (int y=0; y<maze.getHeight(); y++) {
			for (int x=0; x<maze.getWidth(); x++) {
				char decoded=' '; // default value is empty
				switch (mazeArray[y][x]) {
					case  1:
						decoded = '#'; break;
					case -1:
						decoded = 'S'; break;
					case -2:
						decoded = 'E'; break;
					case -3:
						decoded = 'X'; break;
				}
				sb.append(decoded).append(" ");
			}
		    System.out.println(sb.toString());
		    sb.setLength(0);
		}
		if (!mazeResolved) {
			System.out.println("\nNO SOLUTION !!!");
		}
	}

}
