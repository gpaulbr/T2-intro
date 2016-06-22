package org;

public class Pawn extends Piece {
		
	public Pawn(String color){
		super(color);
	}
	
	@Override
	public boolean validateMove(int fromX, int fromY, int toX, int toY){
		if (this.getColor() == "white" && fromX == toX && (fromY-toY == 1)){
			return true;
		}
		else if (this.getColor() == "black" && fromX == toX && (toY-fromY == 1)){
			return true;
		}
		else if (this.getColor() == "white" && fromX == toX && (fromY-toY == 2) && toY == 4){
			return true;
		}
		else if (this.getColor() == "black" && fromX == toX && (toY-fromY == 2) && toY == 3){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		if (this.getColor() == "black") return "P";
		else return "p";
	}
}
