package org;

public class Rook extends Piece {

	public Rook(String color) {
		super(color, 0, 0, 0, 0);
	}
	@Override
	public String toString(){
		return "R";
	}
}
