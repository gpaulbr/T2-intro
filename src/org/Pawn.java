package org;

public class Pawn extends Piece {
		
	public Pawn(String color){
		super(color, 0, 1, 1, 2);
	}
	@Override
	public String toString(){
		return "P";
	}
}
