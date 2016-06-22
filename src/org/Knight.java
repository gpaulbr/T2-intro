package org;

public class Knight extends Piece{

	public Knight(String color) {
		super(color);
	}
	
	@Override
	public boolean validateMove(int fromX, int fromY, int toX, int toY) {
		if (java.lang.Math.abs(fromX - toX) == 2 && java.lang.Math.abs(fromY - toY) == 1) {
			return true;
		}
		
		if (java.lang.Math.abs(fromX - toX) == 1 && java.lang.Math.abs(fromY - toY) == 2) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return "H";
	}
}
