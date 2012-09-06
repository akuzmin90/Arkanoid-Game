package com.alex.arkanoid.service.impl;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.alex.arkanoid.ArkanoidApplication;
import com.alex.arkanoid.GameConstants;
import com.alex.arkanoid.R;
import com.alex.arkanoid.model.Brick;
import com.alex.arkanoid.service.BrickManager;

public class BrickManagerImpl implements BrickManager {

	private List<Brick> brickList = new ArrayList<Brick>();
	
	public List<Brick> ensureBrickList(int canvasWidth) {
		int brickWidth = canvasWidth / GameConstants.BRICKS_HORIZONTAL_COUNT - GameConstants.BRICK_GAP;
		
		Bitmap initialYellowBrick = BitmapFactory.decodeResource(ArkanoidApplication.getAppResources(), R.drawable.yellow_brick);
		Bitmap yellowBrick = Bitmap.createScaledBitmap(initialYellowBrick, 
        		getBrickWidth(canvasWidth), GameConstants.BRICK_HEIGHT, true);
		
		Bitmap initialGreenBrick = BitmapFactory.decodeResource(ArkanoidApplication.getAppResources(), R.drawable.green_brick);
		Bitmap greenBrick = Bitmap.createScaledBitmap(initialGreenBrick, 
        		getBrickWidth(canvasWidth), GameConstants.BRICK_HEIGHT, true);
		
		for (int j = 0; j < GameConstants.BRICKS_VERTICAL_COUNT; ++j) {
    		for (int i = 0; i < GameConstants.BRICKS_HORIZONTAL_COUNT; ++i) {
    			Brick brick = new Brick();

    			brick.setX((brickWidth + GameConstants.BRICK_GAP) * i);
    			brick.setY((GameConstants.BRICK_HEIGHT + GameConstants.BRICK_GAP) * j);
    			brick.setWidth(brickWidth);
    			brick.setHeight(GameConstants.BRICK_HEIGHT);

    			if (i % 2 == 0) {
    				brick.setImage(yellowBrick);
    			} else {
    				brick.setImage(greenBrick);
    			}

    			brickList.add(brick);
    		}
		}
		return brickList;
	}

	public int getBrickWidth(int canvasWidth) {
		return canvasWidth / GameConstants.BRICKS_HORIZONTAL_COUNT - GameConstants.BRICK_GAP;
	}

	public List<Brick> getBrickList() {
		return brickList;
	}

}
