package com.alex.arkanoid.service.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.alex.arkanoid.ArkanoidApplication;
import com.alex.arkanoid.GameConstants;
import com.alex.arkanoid.R;
import com.alex.arkanoid.model.Ball;
import com.alex.arkanoid.service.BallManager;

public class BallManagerImpl implements BallManager {
	
	private int canvasWidth;

	private int canvasHeight;
	
	public void onClock() {
		if (null == ball) {
			return;
		}
		int x = ball.getX();
		int y = ball.getY();
		if (x <= 0) {
			ball.setSpeedX(Math.abs(ball.getSpeedX()));
		} else if (x >= canvasWidth - ball.getRadius() * 2) {
			ball.setSpeedX(-Math.abs(ball.getSpeedX()));
		}
		
		if (y <= 0) {
			ball.setSpeedY(Math.abs(ball.getSpeedY()));
		}
		else if (y > canvasHeight - ball.getRadius() * 2) {
			// ball.setSpeedY(-Math.abs(ball.getSpeedY()));
			// TODO Game Over!
		}
		ball.setX(x + ball.getSpeedX());
		ball.setY(y + ball.getSpeedY());
	}

	private Ball ball;
	
	public Ball ensureBall(int canvasWidth, int canvasHeight) {
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		if (null != ball) {
			return ball;
		}
		ball = new Ball();
		ball.setX(GameConstants.BALL_START_X);
		ball.setY(GameConstants.BALL_START_Y);
		
		ball.setSpeedX(GameConstants.ABS_BALL_SPEED_X);
		ball.setSpeedY(GameConstants.ABS_BALL_SPEED_Y);
		
		ball.setRadius(GameConstants.BALL_RADIUS);

		Bitmap initialImage = BitmapFactory.decodeResource(ArkanoidApplication.getAppResources(), R.drawable.grey_ball);
		Bitmap image = Bitmap.createScaledBitmap(initialImage, 
        		2 * ball.getRadius(), 2 * ball.getRadius(), true);
		
		ball.setImage(image);
		
		return ball;
	}
	
	public Ball getBall() {
		return ball;
	}

}
