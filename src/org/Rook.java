package org;

public class Rook extends Piece {

	public Rook(String color) {
		super(color);
	}
	
	@Override
	public boolean validateMove(int fromX, int fromY, int toX, int toY){
		if (fromX != toX && fromY != toY){
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString(){
		return "R";
	}
}
