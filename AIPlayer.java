package test;

import java.util.Random;

public class AIPlayer extends Player {

	protected AIPlayer(String a) {
		super(a);

	}

	@Override
	public void doMove(Board b) {
		Random rand = new Random();
		State[][] board = b.getGameBoard();
		int row = b.getRow();
		
		for (int i = 0; i < 8; i++) {
			rand.nextInt(8);
		}
		
		int column = rand.nextInt(8);
		
		if (!b.columnIsFull(column)) {
			for (row = 0; row < 6; row++) {
				if ((row == 0) && !board[row + 1][column - 1].equals(State.EMPTY)) {
					board[row][column - 1] = symbol;
					break;
				} else if (!board[row][column - 1].equals(State.EMPTY)) {
					board[row - 1][column - 1] = symbol;
					break;
				} else if (row == 5) {
					board[row][column - 1] = symbol;
					break;
				}
			}
			b.printBoard();
		} 
	}

}