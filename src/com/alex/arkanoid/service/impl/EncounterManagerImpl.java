package com.alex.arkanoid.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alex.arkanoid.GameConstants;
import com.alex.arkanoid.model.Ball;
import com.alex.arkanoid.model.Board;
import com.alex.arkanoid.model.Brick;
import com.alex.arkanoid.model.TriangleDrawable;
import com.alex.arkanoid.service.BallManager;
import com.alex.arkanoid.service.BoardManager;
import com.alex.arkanoid.service.BrickManager;
import com.alex.arkanoid.service.EncounterManager;
import com.google.inject.Inject;

public class EncounterManagerImpl implements EncounterManager {
	
	@Inject
	private BallManager ballManager;
	
	@Inject
	private BrickManager brickManager;
	
	@Inject
	private BoardManager boardManager;
	
	public void onClock() {
		handleEncounters();
	}
	
	private void handleEncounters() {
		Ball ball = ballManager.getBall();
		Board board = boardManager.getBoard();
		List<Brick> brickList = brickManager.getBrickList();
		if (null == ball || null == board || null == brickList) {
			return;
		}
		
		handleBrickEncounters(brickList, ball);
		handleBoardEncounters(board, ball);
	}
	
	private void handleBrickEncounters(List<Brick> brickList, Ball ball) {
		List<Brick> toRemove = new ArrayList<Brick>();
		for (Brick e : brickList) {
			if (handleBallWithTriangleEncounter(e, ball)) {
				toRemove.add(e);
			}
		}
		synchronized (brickList) {
			for (Brick e : toRemove) {
				brickList.remove(e);
			}	
		}
	}
	
	private void handleBoardEncounters(Board board, Ball ball) {
		handleBallWithTriangleEncounter(board, ball);
	}
	
	private boolean handleBallWithTriangleEncounter(TriangleDrawable triangle, Ball ball) {
		boolean encounterHasBeen = false;
		if (ball.getX() <= triangle.getX() + triangle.getWidth() 
				&& ball.getX() >= triangle.getX() + triangle.getWidth() - GameConstants.ABS_BALL_SPEED_X 
				&& ball.getY() + ball.getRadius() * 2 >= triangle.getY() 
				&& ball.getY() <= triangle.getY() + triangle.getHeight()) {
			ball.setSpeedX(Math.abs(ball.getSpeedX()));
			encounterHasBeen = true;
		} else if (ball.getX() + ball.getRadius() * 2 <= triangle.getX() + GameConstants.ABS_BALL_SPEED_X
				&& ball.getX() + ball.getRadius() * 2 >= triangle.getX() 
				&& ball.getY() + ball.getRadius() * 2 >= triangle.getY() 
				&& ball.getY() <= triangle.getY() + triangle.getHeight()) {
			ball.setSpeedX(-Math.abs(ball.getSpeedX()));
			encounterHasBeen = true;
		}
		
		if (ball.getY() + ball.getRadius() * 2 <= triangle.getY() + GameConstants.ABS_BALL_SPEED_Y
				&& ball.getY() + ball.getRadius() * 2 >= triangle.getY() 
				&& ball.getX() < triangle.getX() + triangle.getWidth() 
				&& ball.getX() + ball.getRadius() * 2 > triangle.getX()) {
			ball.setSpeedY(-Math.abs(ball.getSpeedY()));
			encounterHasBeen = true;
		} else if (ball.getY() >= triangle.getY() + triangle.getHeight() - GameConstants.ABS_BALL_SPEED_Y
				&& ball.getY() <= triangle.getY() + triangle.getHeight()
				&& ball.getX() < triangle.getX() + triangle.getWidth() 
				&& ball.getX() + ball.getRadius() * 2 > triangle.getX()) {
			ball.setSpeedY(Math.abs(ball.getSpeedY()));
			encounterHasBeen = true;
		}
		return encounterHasBeen;
	}
	
}
