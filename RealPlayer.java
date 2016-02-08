package test;

import java.util.Scanner;

public class RealPlayer extends Player {

	protected RealPlayer(String a) {
		super(a);

	}

	@Override
	public void doMove(Board b) {
		System.out.println("Choose column to make a turn!");
		Scanner scan = new Scanner(System.in);
		int chosenColumn = scan.nextInt();
		int row = b.getRow();
		State[][] board = b.getGameBoard();

		do {
			if (b.columnIsFull(chosenColumn)) {
				System.out.println("Column is full, please choose another column!");
				chosenColumn = scan.nextInt();
			}
		} while (b.columnIsFull(chosenColumn));

		while (!board[row - 1][chosenColumn - 1].equals(State.EMPTY)) {
			row--;
		}
		board[row-1][chosenColumn -1] = symbol;

		b.printBoard();
	}
}