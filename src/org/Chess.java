package org;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Chess {
	private Board bd;
	
	public void populateBoard(){
		Piece[][] matrix = new Piece[8][8];
		
		for (int l=0; l<8; l++) {
			
			for (int c=0; c<8; c++) {
				
				if (l==1) {
					Pawn p = new Pawn("black");
					matrix [l][c] = p;
				}
				else if (l==6) {
					Pawn p = new Pawn("white");
					matrix [l][c] = p;
				}
				else if((c==0||c==7)&&l==0) {
					Rook r = new Rook("black");
					matrix [l][c] = r;
				}
				else if((c==0||c==7)&&l==7) {
					Rook r = new Rook("white");
					matrix [l][c] = r;
				}
				else if((c==1||c==6)&&l==0) {
					Knight k = new Knight("black");
					matrix [l][c] = k;
				}
				else if((c==1||c==6)&&l==7) {
					Knight k = new Knight("white");
					matrix [l][c] = k;
				}
				else if((c==2||c==5)&&l==0) {
					Bishop b = new Bishop("black");
					matrix [l][c] = b;
				}
				else if((c==2||c==5)&&l==7) {
					Bishop b = new Bishop("white");
					matrix [l][c] = b;
				}
				else if(c==4&&l==0) {
					King k = new King("black");
					matrix [l][c] = k;
				}
				else if(c==3&&l==7) {
					King k = new King("white");
					matrix [l][c] = k;
				}
				else if(c==3&&l==0) {
					Queen q = new Queen("black");
					matrix [l][c] = q;
				}
				else if(c==4&&l==7) {
					Queen q = new Queen("white");
					matrix [l][c] = q;
				}
			}
		}
		bd = new Board(matrix);
	}

	public boolean moveTo(int toX, int toY, int x, int y) {
		Piece p = bd.getMatrix()[y][x];
		if (p.validateMove(x, y, toX, toY)) {
			
			try {
				if (bd.getMatrix()[toY][toX].getColor() == bd.getMatrix()[y][x].getColor()) {
					System.out.println("Posição inválida");
					return false;
				}
			} catch(Exception e) { }
			
			
			if (p instanceof Rook || (p instanceof Pawn && !(p.isAttack())) || p instanceof Queen || p instanceof King) {
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
				if (p instanceof Pawn && !(p.isAttack())) {
					if (bd.getMatrix()[toY][toX] != null){
						System.out.println("Posição inválida");
						return false; 
					}
				}
			}
			
			if (p instanceof Bishop || p instanceof Queen || p instanceof King || (p instanceof Pawn && p.isAttack())) {
				
				if (x > toX && y > toY) {
					
					if (p instanceof Pawn) {
						if (bd.getMatrix()[y-1][x-1] == null) {
							System.out.println("Posição inválida");
							return false;
						}
					}

					for (int i = 1; i < (x - toX); i++) {
						if (bd.getMatrix()[y-i][x-i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
				
				if (x > toX && y < toY) {
					
					if (p instanceof Pawn) {
						if (bd.getMatrix()[y+1][x-1] == null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
					
					for (int i = 1; i < (x - toX); i++) {
						if (bd.getMatrix()[y+i][x-i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
				
				if (x < toX && y < toY) {
					
					if (p instanceof Pawn) {
						if (bd.getMatrix()[y+1][x+1] == null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
					
					for (int i = 1; i < (toX - x); i++) {
						
						if (bd.getMatrix()[y+i][x+i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
				
				if (x < toX && y > toY) {
					
					if (p instanceof Pawn) {
						if (bd.getMatrix()[y-1][x+1] == null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
					
					for (int i = 1; i < (toX - x); i++) {
						if (bd.getMatrix()[y-i][x+i] != null) {
							System.out.println("Posição inválida");
							return false;
						}
					}
				}
			}	
			
			if (p instanceof Pawn) {
				bd.getMatrix()[y][x].setAttack(false);
			}
			
			bd.setPos(toX, toY, p);
			bd.delPos(x, y);
			this.save();
			return true;
		}
		
		System.out.println("Não é valido");
		return false;
	}
	
	public boolean play(String player) {
		
		Scanner in = new Scanner(System.in);
		String pos;
		String move;
		
		boolean valid = false;
		while (!valid) {
			
			System.out.println("Informe a peça que deseja mover, ou digite sair para sair");
			pos = in.nextLine();
			int c = this.getChar(pos);
			int l = this.getNumber(pos);
			if (pos.equals("sair")) {
				java.lang.System.exit(1);
			} else if ((l >= 0 && l <8) 
					&& (c >= 0 && c <8)
					&& (bd.getMatrix()[l][c] != null) 
					&& (bd.getMatrix()[l][c].getColor() == player)){
				System.out.println(bd.getMatrix()[l][c].toString());
				System.out.println("Informe para onde deseja mover a peça, ou digite sair para sair");
				move = in.nextLine();
				if (move.equals("sair")) {
					java.lang.System.exit(1);
				} else {
					valid = this.moveTo(this.getChar(move), this.getNumber(move), c, l);
				}
			}
			else System.out.println("A posição é inválida");
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
	
	public void start(boolean pop) throws Exception {
		boolean end = false;
		int i = 0;
		
		if (pop) {
			this.populateBoard();
		} else {
			this.load();
		}
		
		
		while(!end) {
			
			this.bd.print();
			
			if (i%2 == 0) {
				System.out.println("Peças brancas:");
				end = this.play("white");
			} else { 
				System.out.println("Peças pretas:");
				end = this.play("black");
			}
			
			i++;
		}
	}

	private void load() throws Exception {
		char matriz[][] = new char[8][8];
		int pos = 0;
		String a = null;
		Piece[][] pieceMatrix = new Piece[8][8];
	
		BufferedReader br = new BufferedReader(new FileReader("save.txt"));
		a = br.readLine();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				matriz[i][j] = a.charAt(pos);
				pos++;
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char peca = matriz[i][j];
				switch (peca) {
					case 'p':
						pieceMatrix[i][j] = new Pawn("white");
						break;
					case 'P':
						pieceMatrix[i][j] = new Pawn("black");
						break;
					case 'k':
						pieceMatrix[i][j] = new King("white");
						break;
					case 'K':
						pieceMatrix[i][j] = new King("black");
						break;
					case 'r':
						pieceMatrix[i][j] = new Rook("white");
						break;
					case 'R':
						pieceMatrix[i][j] = new Rook("black");
						break;
					case 'b':
						pieceMatrix[i][j] = new Bishop("white");
						break;
					case 'B':
						pieceMatrix[i][j] = new Bishop("black");
						break;
					case 'q':
						pieceMatrix[i][j] = new Queen("white");
						break;
					case 'Q':
						pieceMatrix[i][j] = new Queen("black");
						break;
					case 'h':
						pieceMatrix[i][j] = new Knight("white");
						break;
					case 'H':
						pieceMatrix[i][j] = new Knight("black");
						break;
				}
			}
		}
		bd = new Board(pieceMatrix);
	}
	
	private void save() {
		List<String> lines;
		Path file = Paths.get("save.txt");
		String save = "";
		 
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (bd.getMatrix()[i][j] == null) {
					save += "-";
				} else {
					save += bd.getMatrix()[i][j].toString();
				}
			}
		}
		
		lines = Arrays.asList(save);
		
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			System.out.println("Não foi possivel salvar o jogo");
		}
	}
}
