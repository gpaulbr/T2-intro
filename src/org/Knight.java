package org;

public class Knight extends Piece{

	public Knight(String color) {
		super(color);
	}
	
	@Override
	public boolean validateMove(int fromX, int fromY, int toX, int toY) {
		return false;
	}
	
	@Override
	public String toString(){
		return "H";
	}
}
