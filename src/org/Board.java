package org;

public class Board {
	private Piece[][] matrix = new Piece[8][8];
	private int wKingX, wKingY, bKingX, bKingY;
	
	public Board(Piece[][] matrix) {
		this.matrix = matrix;
		this.wKingX = 4;
		this.wKingY = 7;
		this.bKingX = 3;
		this.bKingY = 0;
	}

	public int getwKingX() {
		return wKingX;
	}

	public void setwKingX(int wKingX) {
		this.wKingX = wKingX;
	}

	public int getwKingY() {
		return wKingY;
	}

	public void setwKingY(int wKingY) {
		this.wKingY = wKingY;
	}

	public int getbKingX() {
		return bKingX;
	}

	public void setbKingX(int bKingX) {
		this.bKingX = bKingX;
	}

	public int getbKingY() {
		return bKingY;
	}

	public void setbKingY(int bKingY) {
		this.bKingY = bKingY;
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