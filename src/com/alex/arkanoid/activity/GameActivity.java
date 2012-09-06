package com.alex.arkanoid.activity;

import java.util.List;

import roboguice.activity.RoboActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.alex.arkanoid.model.Ball;
import com.alex.arkanoid.model.Board;
import com.alex.arkanoid.model.Brick;
import com.alex.arkanoid.service.BallManager;
import com.alex.arkanoid.service.BoardManager;
import com.alex.arkanoid.service.BrickManager;
import com.alex.arkanoid.service.EncounterManager;
import com.google.inject.Inject;

public class GameActivity extends RoboActivity {
	
	@Inject
	private BrickManager brickManager;
	
	@Inject
	private BoardManager boardManager;
	
	@Inject
	private BallManager ballManager;
	
	@Inject
	private EncounterManager encounterManager;
	
    private class GraphicsView extends View {
    	
    	private static final int INVALIDATE_INTERVAL = 10;
    	
    	private List<Brick> brickList;
    	private Board board;
    	private Ball ball;
    	
    	public GraphicsView(Context context) {
    		super(context);
    	}
    	
    	@Override
    	public void onSizeChanged(int w, int h, int oldW, int oldH) {
    		brickList = brickManager.ensureBrickList(w);
    		board = boardManager.ensureBoard(w, h);
    		ball = ballManager.ensureBall(w, h);
    	}
    	
    	@Override
    	protected void onDraw(Canvas canvas) {
    		encounterManager.onClock();
    		ballManager.onClock();
    		if (null != brickList) {
    	    	for (Brick brick : brickList) {
    	    		canvas.drawBitmap(brick.getImage(), brick.getX(), brick.getY(), null);
    	    	}
    		}
    		if (null != board) {
    			canvas.drawBitmap(board.getImage(), board.getX(), board.getY(), null);
    		}
    		if (null != ball) {
    			canvas.drawBitmap(ball.getImage(), ball.getX(), ball.getY(), null);
    		}
    		postInvalidateDelayed(INVALIDATE_INTERVAL);
    	}

    	@Override
    	public boolean onTouchEvent(MotionEvent event) {
    		if (MotionEvent.ACTION_DOWN == event.getAction()) {
    			boardManager.handleActionDown((int) event.getX(), (int) event.getY());
    		} else if (MotionEvent.ACTION_MOVE == event.getAction()) {
    			boardManager.onActionMove((int) event.getX(), (int) event.getY());
    		} else if (MotionEvent.ACTION_UP == event.getAction()) {
    			boardManager.onActionUp((int) event.getX(), (int) event.getY());
    		}
			return true;
    	}
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraphicsView graphicsView = new GraphicsView(this);
        setContentView(graphicsView);
    }

}
