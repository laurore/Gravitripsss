package test;



public class Game {

	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Board board = new Board();

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;

	}

	public void playGame() {
		currentPlayer = player1;
		while (!board.boardIsFull() && board.winner().equals(State.EMPTY)) {
			
			currentPlayer.doMove(board);
			switchPlayer();
			
		}
		if (board.boardIsFull() || !board.winner().equals(State.EMPTY)) {
			finishGame();
		}

	}

	private void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}

	}

	private void finishGame() {
		State winner = board.winner();
		if (winner == State.X) {
			System.out.println("Congratulations player X, you've won!");
		} else if (winner == State.O) {
			System.out.println("Congratulations, player O, you've won!");
		} else {
			System.out.println("Well played guys, it's a draw! Play again!");

		}

	}


}
