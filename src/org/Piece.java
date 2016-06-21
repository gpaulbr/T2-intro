package org;

public abstract class Piece {
	private String color;
	
	public Piece(String color) {
		this.color = color;
	}
	
	public boolean validateMove(int fromX, int fromY, int toX, int toY){
		return false;
	}
	
	public String getColor() {
		return color;
	}
}
