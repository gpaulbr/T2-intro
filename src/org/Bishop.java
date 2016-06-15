package org;

public class Bishop extends Piece {

	public Bishop(String color) {
		super(color, 0, 0, 0, 0);
	}
	@Override
	public String toString(){
		return "B";
	}
}
