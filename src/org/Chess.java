package org;

import java.util.Scanner;

public class Chess {
	private Board bd;
	
	public void populateBoard(){
		Piece[][] matrix = new Piece[8][8];
		
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
		bd = new Board(matrix);
	}

	public void moveTo(int row, int collumn, int rowP, int collumnP){
		if (bd.getMatrix()[collumnP][rowP].validadeMove(rowP, collumnP, collumn, row)){
			System.out.println("É valido");
		}
		else System.out.println("Não é valido");
	}
	
	public boolean play(String player){
		Scanner in = new Scanner(System.in);
		String pos;
		String move;
		boolean valid = false;
		while (!valid){
			System.out.println("Informe a letra e o n�mero da pe�a");
			pos = in.nextLine();
			int l = this.getChar(pos);
			int c = this.getNumber(pos);
			if ((l >= 0 && l <8) 
					&& (c >= 0 && c <8)
					&& (bd.getMatrix()[c][l]!= null) 
					&& (bd.getMatrix()[c][l].getColor()==player)){
				valid = true;
				System.out.println(bd.getMatrix()[c][l].toString());
				System.out.println("Informe para onde deseja mover a peça");
				move = in.nextLine();
				this.moveTo(this.getNumber(move), this.getChar(move), l, c);
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
	
	public void start(){
		boolean end = false;
		this.populateBoard();
		while(!end){
			this.bd.print();
			end = this.play("white");
			end = this.play("black");
		}
	}
}
