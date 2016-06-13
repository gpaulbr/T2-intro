package org;

public class App {

	public static void main(String args[]){
		Board bd = new Board();
		boolean end = false;
		while(!end){
			bd.print();
			end = bd.play("white");
		}
	}
}
