package org;

import java.util.Scanner;
import java.io.IOException;

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

	public boolean moveTo(int toX, int toY, int x, int y){
//		System.out.println(toX +" "+ toY +" "+ x +" "+ y);
		Piece p = bd.getMatrix()[y][x];
		if (p.validateMove(x, y, toX, toY)) {
			
			try {
				if (bd.getMatrix()[toY][toX].getColor() == bd.getMatrix()[y][x].getColor()){
					System.out.println("Posição inválida");
					return false;
				}
			} catch(Exception e) { }
			
			
			if (p instanceof Rook || p instanceof Pawn || p instanceof Queen) {
				int minX;
				int maxX;
				int minY;
				int maxY;
				
				if (x < toX) {
					minX = x;
					maxX = toX;
				} else {
					minX = toX;
					maxX = x;
				}
				
				for (int i = minX+1; i < maxX; i++) {
					
					if (bd.getMatrix()[y][i] != null) {
						System.out.println("Posição inválida");
						return false;
					}
				}
				
				if (y < toY) {
					minY = y;
					maxY = toY;
				} else {
					minY = toY;
					maxY = y;
				}
				
				for (int i = minY+1; i < maxY; i++) {
					
					if (bd.getMatrix()[i][x] != null) {
						System.out.println("Posição inválida");
						return false;
					}
				}
			}
			
			if (p instanceof Bishop || p instanceof Queen) {
				
				if (x > toX && y > toY) {
					for (int i = 1; i < (x - toX); i++) {
						if (bd.getMatrix()[y-i][x-i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
				
				if (x > toX && y < toY) {
					for (int i = 1; i < (x - toX); i++) {
						if (bd.getMatrix()[y+i][x-i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
				
				if (x < toX && y < toY) {
					for (int i = 1; i < (toX - x); i++) {
						if (bd.getMatrix()[y+i][x+i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
				
				if (x < toX && y > toY) {
					
					for (int i = 1; i < (toX - x); i++) {
						if (bd.getMatrix()[y-i][x+i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
			}
					
			bd.setPos(toX, toY, p);
			bd.delPos(x, y);
			return true;
		}
		
		System.out.println("Não é valido");
		return false;
	}
	
	public boolean play(String player){
		Scanner in = new Scanner(System.in);
		String pos;
		String move;
		boolean valid = false;
		while (!valid){
			System.out.println("Informe a letra e o n�mero da pe�a");
			pos = in.nextLine();
			int c = this.getChar(pos);
			int l = this.getNumber(pos);
			if ((l >= 0 && l <8) 
					&& (c >= 0 && c <8)
					&& (bd.getMatrix()[l][c] != null) 
					&& (bd.getMatrix()[l][c].getColor() == player)){
				System.out.println(bd.getMatrix()[l][c].toString());
				System.out.println("Informe para onde deseja mover a peça");
				move = in.nextLine();
				valid = this.moveTo(this.getChar(move), this.getNumber(move), c, l);
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
	
	public void start() throws IOException{
		boolean end = false;
		this.populateBoard();
		while(!end){
			Runtime.getRuntime().exec("clear");
			this.bd.print();
			end = this.play("white");
//			clearConsole();
			Runtime.getRuntime().exec("clear");
			this.bd.print();
			end = this.play("black");
//			clearConsole();
		}
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        System.out.println("Wasn't able to clear the console");
	    }
	}
}
