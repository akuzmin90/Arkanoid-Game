package com.alex.arkanoid.model;


public class Brick extends TriangleDrawable {

	@Override
	public boolean equals(Object rhs) {
		if (null == rhs) {
			return false;
		}
		if (!(rhs instanceof Brick)) {
			return false;
		}
		Brick brick = (Brick) rhs;
		if (getX() == brick.getX() && getY() == brick.getY() && width == brick.width && height == brick.height) {
			return true;
		}
		return false;
	}

}