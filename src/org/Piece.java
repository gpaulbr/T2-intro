package org;

public abstract class Piece {
	private String color;
	private int movx;
	private int movy;
	
	public Piece(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public int getMovx() {
		return movx;
	}
	
	public int getMovy() {
		return movy;
	}
}
