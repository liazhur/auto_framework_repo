package pages.products;

import java.util.ArrayList;
import java.util.List;

public class Product {

	String productName = "Printed Chiffon Dress";
	String size = "M";
	String totalProducts;
	String totalShippingValue;
	String totalValue;
	List<String> tableValues = new ArrayList<String>();

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Product setTableValues(List<String> tableValues) {
		this.tableValues = tableValues;
		return this;
	}

	public List<String> getTableValues() {
		return tableValues;
	}

	public String getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(String totalProducts) {
		this.totalProducts = totalProducts;
	}

	public void setTotalShippingValue(String totalShippingValue) {
		this.totalShippingValue = totalShippingValue;
	}

	public String getTotalShippingValue() {
		return totalShippingValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}

	public String getTotalValue() {
		return totalValue;
	}
}