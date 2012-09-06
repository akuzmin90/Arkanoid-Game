package com.alex.arkanoid.model;

public class Board extends TriangleDrawable {
	
	private boolean isDragged;
	
	private int touchIndent = 0;
	
	public void setIsDragged(boolean isDragged) {
		this.isDragged = isDragged;
	}
	
	public boolean getIsDragged() {
		return isDragged;
	}
	
	public void setTouchIndent(int touchIndent) {
		this.touchIndent = touchIndent;
	}
	
	public int getTouchIndent() {
		return touchIndent;
	}
	
}
