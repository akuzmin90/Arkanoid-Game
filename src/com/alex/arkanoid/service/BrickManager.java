package com.alex.arkanoid.service;

import java.util.List;

import com.alex.arkanoid.model.Brick;

public interface BrickManager {

	/**
	 * Creates the brick list and returns it if it does not exist.
	 * Just returns brick list if has been created already.
	 */
	List<Brick> ensureBrickList(int canvasWidth);
	
	/**
	 * Returns the brick list, or returns null if it does not exist.
	 */
	List<Brick> getBrickList();
	
	int getBrickWidth(int canvasWidth);
	
}
