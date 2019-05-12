package pages.products;

public enum Products {
	PRINTED_CHIFFON_DRESS("Printed Chiffon Dress"), SIZE_M("M");

	private String name;

	Products(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}