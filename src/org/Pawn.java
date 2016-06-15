package org;

public class Pawn extends Piece {
		
	public Pawn(String color){
		super(color, 0, 1, 1, 2);
	}
	
	@Override
	public boolean validadeMove(int fromX, int fromY, int toX, int toY){
		if (this.getColor() == "white" && fromX == toX && (fromY-toY == 1)){
			return true;
		}
		else if (this.getColor() == "black" && fromX == toX && (toY-fromY == 1)){
			return true;
		}
		else return false;
	}
	
	@Override
	public String toString(){
		return "P";
	}
}
