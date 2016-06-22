package org;

public class Bishop extends Piece {

	public Bishop(String color) {
		super(color);
	}
	
	@Override
	public boolean validateMove(int fromX, int fromY, int toX, int toY){
		if (java.lang.Math.abs(fromX - toX) == java.lang.Math.abs(fromY - toY)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		if (this.getColor() == "black") return "B";
		else return "b";
	}
}
