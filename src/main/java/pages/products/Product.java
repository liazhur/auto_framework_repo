package pages.products;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import pages.BasePage;
import pages.checkout.ProductTable;

public class Product extends BasePage {

	public Product(WebDriver driver) {
		super(driver);
	}

	private String productName;
	private String size;
	private String totalProducts;
	private String totalShippingValue;
	private String totalValue;
	private List<String> tableValues = new ArrayList<String>();
	private ProductTable productTable;

	public ProductTable getProductTable() {
		if (productTable == null) {
			productTable = new ProductTable(driver);
		}
		return productTable;
	}

	public void setProductTable(ProductTable productTable) {
		this.productTable = productTable;
	}

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

	public void setTableValues(List<String> tableValues) {
		this.tableValues = tableValues;
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