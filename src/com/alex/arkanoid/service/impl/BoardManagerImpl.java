package com.alex.arkanoid.service.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.alex.arkanoid.ArkanoidApplication;
import com.alex.arkanoid.GameConstants;
import com.alex.arkanoid.R;
import com.alex.arkanoid.model.Board;
import com.alex.arkanoid.service.BoardManager;

public class BoardManagerImpl implements BoardManager {

	private Board board;
	
	public void handleActionDown(int x, int y) {
		if (null == board) {
			return;
		}
		if (x < board.getX() + board.getWidth()
				&& x > board.getX() 
				&& y < board.getY() + board.getHeight()
				&& y > board.getY()) {
			board.setIsDragged(true);
			board.setTouchIndent(x - board.getX());
		}
	}

	public void onActionMove(int x, int y) {
		if (null == board) {
			return;
		}
		if (board.getIsDragged()) {
			board.setX((int) x - board.getTouchIndent());
		}
	}

	public void onActionUp(int x, int y) {
		if (null == board) {
			return;
		}
		board.setIsDragged(false);
	}

	public Board ensureBoard(int canvasWidth, int canvasHeight) {
		if (null != board) {
			return board;
		}
		board = new Board();
		board.setWidth(GameConstants.BOARD_WIDTH);
		board.setHeight(GameConstants.BOARD_HEIGHT);
		board.setIsDragged(false);
		board.setTouchIndent(0);
		board.setX(canvasWidth / 2);
		board.setY(canvasHeight - board.getHeight());
		
		Bitmap initialBrickImage = BitmapFactory.decodeResource(ArkanoidApplication.getAppResources(), R.drawable.board1);
		Bitmap image = Bitmap.createScaledBitmap(initialBrickImage, 
				GameConstants.BOARD_WIDTH, GameConstants.BOARD_HEIGHT, true);
		board.setImage(image);
		return board;
	}

	public Board getBoard() {
		return board;
	}

}
