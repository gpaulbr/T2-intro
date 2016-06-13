package org;

import java.util.Scanner;

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
		System.out.println("  | |a||b||c||d||e||f||g||h|");
		System.out.println("  |-------------------------");
		for (int l=0; l<8; l++){
			System.out.print("|"+l+"| ");
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
	
	public boolean play(String player){
		Scanner in = new Scanner(System.in);
		String move;
		boolean valid = false;
		while (!valid){
			System.out.println("Informe a letra e o n�mero da pe�a");
			move = in.nextLine();
			int movy = this.getChar(move);
			int movx = this.getNumber(move);
			if ((movx >= 0 && movx <8) 
					&& (movy >= 0 && movy <8)
					&& (matrix[movx][movy]!= null) 
					&& (matrix[movx][movy].getColor()==player)){
				valid = true;
				System.out.println(matrix[movx][movy].toString());
			}
			else System.out.println("A posi��o � inv�lida");
		}		
		return false;
	}
	
	public int getChar(String move){
		char character = move.charAt(0);
		int number = java.lang.Character.getNumericValue(character);
		return number-10;
	}


	public int getNumber(String move){
		char character = move.charAt(1);
		int number = java.lang.Character.getNumericValue(character);
		return number;
	}
	
}