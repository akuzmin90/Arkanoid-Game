package com.alex.arkanoid.service;

import com.alex.arkanoid.model.Board;

public interface BoardManager {
	
	/**
	 * Creates the board and returns it if board does not exist.
	 * Just returns board if has been created already.
	 */
	public Board ensureBoard(int canvasWidth, int canvasHeight);
	
	/**
	 * Returns the board, or returns null if it does not exist.
	 */
	public Board getBoard();
	
	public void handleActionDown(int x, int y);
	
	public void onActionMove(int x, int y);
	
	public void onActionUp(int x, int y);
	
}
