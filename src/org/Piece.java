package org;

public abstract class Piece {
	private String color;
	private int minX;
	private int	minY;
	private int	maxX;
	private int	maxY;
	
	public Piece(String color, int minX, int maxX, int minY, int maxY) {
		this.color = color;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	public String getColor() {
		return color;
	}
	
	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}
}
