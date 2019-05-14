package pages.tabs;

public enum Tab {
	WOMEN("Women"), DRESSES("Dresses"), TSHIRTS("T-Shirts");

	private String name;

	Tab(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}