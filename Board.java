package test;

public class Board {

	private int row = 6;
	private int column = 7;
	private static final int WIN = 3;
	private State gameBoard[][] = new State[row][column];

	public Board() {
		for (row = 0; row < 6; row++) {
			for (column = 0; column < 7; column++) {
				gameBoard[row][column] = State.EMPTY;
			}
		}
		printBoard();
	}

	public State[][] getGameBoard() {
		return gameBoard;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void printBoard() {
		System.out.println("1 2 3 4 5 6 7");
		for (row = 0; row < 6; row++) {
			for (column = 0; column < 7; column++) {
				System.out.print(gameBoard[row][column] + " ");
			}
			System.out.println(" ");
		}
	}

	public boolean boardIsFull() {
		for (row = 0; row < 6; row++) {
			for (column = 0; column < 7; column++) {
				if (!gameBoard.equals(State.EMPTY)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean columnIsFull(int column) {
		for (row = 0; row < 6; row++) {
			if (gameBoard[row][column - 1].equals(State.EMPTY)) {
				return false;
			}
		}
		return true;
	}

	public State winner() {

		if (!winnerInHorizontal().equals(State.EMPTY)) {
			return winnerInHorizontal();
		}
		if (!winnerInVertical().equals(State.EMPTY)) {
			return winnerInVertical();
		}
		if (!winnerInRightDiagonal().equals(State.EMPTY)) {
			return winnerInRightDiagonal();
		}
		if (!winnerInLeftDiagonal().equals(State.EMPTY)) {
			return winnerInLeftDiagonal();
		}
		return State.EMPTY;
	}

	public State winnerInHorizontal() {
		int count = 1;
		for (row = 0; row < 6; row++) {
			for (column = 0; column < 6; column++) {
				if ((gameBoard[row][column] == gameBoard[row][column + 1])
						&& (!gameBoard[row][column].equals(State.EMPTY))) {
					count++;
					if (count == WIN) {
						return gameBoard[row][column];
					}
				} else {
					count = 0;
				}
			}
		}
		return State.EMPTY;
	}

	public State winnerInVertical() {
		int count = 1;
		for (column = 0; column < 7; column++) {
			for (row = 0; row < 5; row++) {
				if ((gameBoard[row][column] == gameBoard[row + 1][column])
						&& (!gameBoard[row][column].equals(State.EMPTY))) {
					count++;
					if (count == WIN) {
						return gameBoard[row][column];
					}
				} else {
					count = 0;
				}

			}

		}
		return State.EMPTY;
	}

	public State winnerInRightDiagonal() {

		for (int column = WIN; column < 7; column++) {
			int startX = 1;
			int startY = column - 1;
			if (!checkRightDiagonal(startX, startY).equals(State.EMPTY)) {
				return checkRightDiagonal(startX, startY);
			}

		}

		for (int row = 1; row < WIN; row++) {
			int startX = row + 1;
			int startY = 5;
			if (!checkRightDiagonal(startX, startY).equals(State.EMPTY)) {
				return checkRightDiagonal(startX, startY);
			}
		}

		return State.EMPTY;
	}

	public State winnerInLeftDiagonal() {

		for (int column = WIN; column >= 0; column--) {
			int startX = 1;
			int startY = column + 1;
			if (!checkLeftDiagonal(startX, startY).equals(State.EMPTY)) {
				return checkLeftDiagonal(startX, startY);
			}
		}
		for (int row = 1; row < WIN; row++) {
			int startX = row + 1;
			int startY = 1;
			if (!checkLeftDiagonal(startX, startY).equals(State.EMPTY)) {
				return checkLeftDiagonal(startX, startY);
			}
		}
		return State.EMPTY;
	}

	public State checkRightDiagonal(int startX, int startY) {
		int count = 1;
		for (row = startX, column = startY; row < 6 && column >= 0; row++, column--) {
			if ((gameBoard[row][column] == gameBoard[row - 1][column + 1])
					&& (!gameBoard[row][column].equals(State.EMPTY))) {
				count++;
				if (count == WIN) {
					return gameBoard[row][column];
				}
			} else {
				count = 0;
			}
		}
		return State.EMPTY;
	}

	public State checkLeftDiagonal(int startX, int startY) {
		int count = 1;
		for (row = startX, column = startY; row < 6 && column < 7; row++, column++) {
			if ((gameBoard[row][column] == gameBoard[row - 1][column - 1])
					&& (!gameBoard[row][column].equals(State.EMPTY))) {
				count++;

				if (count == WIN) {
					return gameBoard[row][column];
				}
			} else {
				count = 0;
			}
		}

		return State.EMPTY;

	}

}
