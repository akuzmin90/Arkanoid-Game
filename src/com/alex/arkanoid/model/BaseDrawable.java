package com.alex.arkanoid.model;

import android.graphics.Bitmap;

public class BaseDrawable {

	private int x;

	private int y;
	
	private Bitmap image;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setImage(Bitmap image) {
		this.image = image;
	}
	
	public Bitmap getImage() {
		return image;
	}
	
}
