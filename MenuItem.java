package test;

public enum MenuItem {
	PVP(1), 
	PVAI(2);


	private int number;

	private MenuItem(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
