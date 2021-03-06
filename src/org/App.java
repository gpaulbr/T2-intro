package org;

import java.io.IOException;
import java.util.Scanner;

public class App {
	
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		Chess chess = new Chess();
		int op;
		boolean menu = true;
		
		while (menu) {
			System.out.println("Para começar um novo jogo digite 1");
			System.out.println("Para carregar o último jogo digite 2");
			System.out.println("Para sair digite 0");
			op = in.nextInt();
			
			switch (op) {
				
				case 1:
					chess.start(true);
					menu = false;
					break;
				
				case 2:
					menu = false;
					try {
						chess.start(false);
					} catch (Exception e) {
						System.out.println("Nenhum jogo encontrado! Para começar um novo jogo digite 1, para sair digite 0");
						op = in.nextInt();
						switch(op) {
							case 1:
								chess.start(true);
								break;
							case 2:
								break;
						}
						
					}
					
					break;
				
				case 0:
					menu = false;
//					java.lang.System.exit(0);
					break;
			}			
		}
	}
}
