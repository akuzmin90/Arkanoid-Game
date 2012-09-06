package com.alex.arkanoid.service;

import com.alex.arkanoid.model.Ball;

public interface BallManager {

	/**
	 * Creates the ball and returns it if ball does not exist.
	 * Just returns ball if it has been already created.
	 */
	Ball ensureBall(int canvasWidth, int canvasHeight);
	
	/**
	 * Returns the ball, or returns null if it does not exist.
	 */
	Ball getBall();
	
	void onClock();
	
}
