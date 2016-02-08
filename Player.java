package test;

public abstract class Player {
	
	protected State symbol;
	
	protected Player(String a) {
		if(a.equals ("X")) {
			symbol = State.X;
		} else if (a.equals ("O")) {
			symbol = State.O;
		}
	}

	public abstract void doMove(Board board);
	
}
