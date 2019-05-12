package pages.products;

public enum Products {
	PRINTED_CHIFFON_DRESS("Printed Chiffon Dress");

	private String name;

	Products(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}