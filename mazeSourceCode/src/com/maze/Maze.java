package com.maze;
/*	The Maze class represents the maze map loaded from file
 *
 * */
class Maze {

	private int height;
	private int width;
	private int startY; //Y coordinate for maze start position from top to bottom
	private int startX; //X coordinate for maze start position from left to right
	private int endY;   //Y coordinate for maze end position from top to bottom
	private int endX;   //X coordinate for maze end position from left to right

	/**
	Stores Maze state
		Where each number is coded like:
		0..M => ' ' - empty cell, M can be any positive number, the range 0..M excludes 1
		 1 => '#' - wall
		-1 => 'S' - start
		-2 => 'E' - exit
		-3 => 'X' - path
	*/
	private int [][] mazeArray;

	public int[][] getMazeArray() {
		return mazeArray;
	}

	public void setMazeArray(int[][] mazeMap) {
		this.mazeArray = mazeMap;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

}
