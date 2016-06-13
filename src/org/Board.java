package org;

public class Board {
	private Piece[][] matrix = new Piece[8][8];
	
	public Board(){
		for (int l=0; l<8; l++){
			for (int c=0; c<8; c++){
				if (l==1){
					Pawn p = new Pawn("black");
					matrix [l][c] = p;
				}
				else if (l==6){
					Pawn p = new Pawn("white");
					matrix [l][c] = p;
				}
				else if((c==0||c==7)&&l==0){
					Rook r = new Rook("black");
					matrix [l][c] = r;
				}
				else if((c==0||c==7)&&l==7){
					Rook r = new Rook("white");
					matrix [l][c] = r;
				}
				else if((c==1||c==6)&&l==0){
					Knight k = new Knight("black");
					matrix [l][c] = k;
				}
				else if((c==1||c==6)&&l==7){
					Knight k = new Knight("white");
					matrix [l][c] = k;
				}
				else if((c==2||c==5)&&l==0){
					Bishop b = new Bishop("black");
					matrix [l][c] = b;
				}
				else if((c==2||c==5)&&l==7){
					Bishop b = new Bishop("white");
					matrix [l][c] = b;
				}
				else if(c==3&&l==0){
					King k = new King("black");
					matrix [l][c] = k;
				}
				else if(c==4&&l==7){
					King k = new King("white");
					matrix [l][c] = k;
				}
				else if(c==4&&l==0){
					Queen q = new Queen("black");
					matrix [l][c] = q;
				}
				else if(c==3&&l==7){
					Queen q = new Queen("white");
					matrix [l][c] = q;
				}
			}
		}
	}
	public void print(){
		for (int l=0; l<8; l++){
			for (int c=0; c<8; c++){
				if(matrix[l][c]!= null){
					System.out.print("|"+matrix[l][c].toString()+"|");
				}
				else{
					System.out.print("|-|");
				}
			}
			System.out.println();
		}
	}
}
