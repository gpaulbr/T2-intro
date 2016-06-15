package org;

public class Queen extends Piece {

	public Queen(String color) {
		super(color, 0, 0, 0, 0);
	}
	@Override
	public String toString(){
		return "Q";
	}
}
