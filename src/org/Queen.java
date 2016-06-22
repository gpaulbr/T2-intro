package org;

public class Queen extends Piece {

	public Queen(String color) {
		super(color);
	}
	
	@Override
	public boolean validateMove(int fromX, int fromY, int toX, int toY) {
		if (java.lang.Math.abs(fromX - toX) == java.lang.Math.abs(fromY - toY)) {
			return true;
		}
		
		if (!(fromX != toX && fromY != toY)) {
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		if (this.getColor() == "black") return "Q";
		else return "q";
	}
}
