package org;

public class Knight extends Piece{

	public Knight(String color) {
		super(color, 0, 0, 0, 0);
	}
	
	@Override
	public String toString(){
		return "C";
	}
}
