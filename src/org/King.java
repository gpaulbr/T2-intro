package org;

public class King extends Piece {

	public King(String color) {
		super(color, 0, 0, 0, 0);
	}
	@Override
	public String toString(){
		return "K";
	}
}
