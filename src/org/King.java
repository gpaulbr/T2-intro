package org;

public class King extends Piece {

	public King(String color) {
		super(color);
	}
	
	@Override
	public boolean validateMove(int fromX, int fromY, int toX, int toY) {
		int minX, maxX, minY, maxY;
		
		if (fromX < toX){
			minX = fromX;
			maxX = toX;
		} else {
			minX = toX;
			maxX = fromX;
		}
		
		if (fromY < toY){
			minY = fromY;
			maxY = toY;
		} else {
			minY = toY;
			maxY = fromY;
		}
		
		if (maxX - minX == 1 || maxY - minY == 1){
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		if (this.getColor() == "black") return "K";
		else return "k";
	}
}
