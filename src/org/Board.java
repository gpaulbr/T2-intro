package org;

public class Board {
	private Piece[][] matrix = new Piece[8][8];
	
	public Board(Piece[][] matrix) {
		this.matrix = matrix;
	}

	public Piece[][] getMatrix() {
		return this.matrix;
	}
		
	public void setPos(int posx, int posy, Piece piece) {
		this.matrix[posy][posx] = piece;
	}
	
	public void delPos(int posx, int posy) {
		this.matrix[posy][posx] = null;
	}
	
	public void print() {
		System.out.println("  | |a||b||c||d||e||f||g||h|");
		System.out.println("  |-------------------------");
		for (int l=0; l<8; l++){
			System.out.print("|"+l+"| ");
			for (int c=0; c<8; c++){
				if(matrix[l][c]!= null) {
					System.out.print("|"+matrix[l][c].toString()+"|");
				}
				else {
					System.out.print("|-|");
				}
			}
			System.out.println();
		}
	}	
}