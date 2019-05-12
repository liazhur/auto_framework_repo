package pages;

public enum SubMenu {
	CASUAL_DRESSES("Casual Dresses"), EVENING_DRESSES("Evening Dresses"), SUMMER_DRESSES("Summer Dresses");

	private String name;

	SubMenu(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
