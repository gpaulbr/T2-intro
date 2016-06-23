package org;

public class Pawn extends Piece {
	private boolean attack;
	
	public Pawn(String color){
		super(color);
		this.attack = false;
	}
	
	@Override
	public boolean isAttack() {
		return attack;
	}

	@Override
	public void setAttack(boolean attack) {
		this.attack = attack;
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
		
		else if (this.getColor() == "white" && java.lang.Math.abs(fromX - toX) == java.lang.Math.abs(fromY - toY) && fromY-toY == 1){
			this.attack = true;
			return true;
		}
		
		else if (this.getColor() == "black" && java.lang.Math.abs(fromX - toX) == java.lang.Math.abs(fromY - toY) && toY-fromY == 1){
			this.attack = true;
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
