package pages.subcategories;

public enum View {
	GRID("Grid"), List("List");

	private String name;

	View(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
