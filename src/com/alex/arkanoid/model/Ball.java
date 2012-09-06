package com.alex.arkanoid.model;

public class Ball extends BaseDrawable {

	private int radius;
	
	private int speedX;
	
	private int speedY;
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
	public int getSpeedX() {
		return speedX;
	}
	
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public int getSpeedY() {
		return speedY;
	}
	
}
