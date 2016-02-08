package test;

public enum State {
	
	X("X"),
	O("O"),
	EMPTY(".");
	
	private String symbol;
	
	private State(String symbol) {
		this.symbol = symbol;
	}

	@Override
	   public String toString() {
	       return symbol;
	   }
	
}