package test;

import static test.MenuItem.PVAI;
import static test.MenuItem.PVP;


import java.util.Scanner;

public class Gamerun {

	public static void main(String[] args) {

		System.out.println("Hello!");
		System.out.println("Game menu:");
		System.out.println(PVP.getNumber() + " - Player vs Player");
		System.out.println(PVAI.getNumber() + " - Player vs AI Player");

		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		Game game;
		if (input == PVP.getNumber() || input == PVAI.getNumber()) {
			if (input == PVP.getNumber()) {
				game = new Game(new RealPlayer("X"), new RealPlayer("O"));
			} else {
				game = new Game(new RealPlayer("X"), new AIPlayer("O"));
			} 
			game.playGame();
			
		}
	
		
		

	}
}
