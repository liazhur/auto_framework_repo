package pages;

public enum Tab {
	PRODUCT_CATEGORY("Product Category", null), WOMEN("Women", PRODUCT_CATEGORY), DRESSES("Dresses", PRODUCT_CATEGORY),
	TSHIRTS("T-Shirts", PRODUCT_CATEGORY);

	private String name;
	private Tab parentTab;

	Tab(String name, Tab parentTab) {
		this.name = name;
		this.parentTab = parentTab;
	}

	public Tab getParentTab() {
		return parentTab;
	}

	public String getName() {
		return name;
	}
}