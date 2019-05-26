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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productTable == null) ? 0 : productTable.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((tableValues == null) ? 0 : tableValues.hashCode());
		result = prime * result + ((totalProducts == null) ? 0 : totalProducts.hashCode());
		result = prime * result + ((totalShippingValue == null) ? 0 : totalShippingValue.hashCode());
		result = prime * result + ((totalValue == null) ? 0 : totalValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productTable == null) {
			if (other.productTable != null)
				return false;
		} else if (!productTable.equals(other.productTable))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (tableValues == null) {
			if (other.tableValues != null)
				return false;
		} else if (!tableValues.equals(other.tableValues))
			return false;
		if (totalProducts == null) {
			if (other.totalProducts != null)
				return false;
		} else if (!totalProducts.equals(other.totalProducts))
			return false;
		if (totalShippingValue == null) {
			if (other.totalShippingValue != null)
				return false;
		} else if (!totalShippingValue.equals(other.totalShippingValue))
			return false;
		if (totalValue == null) {
			if (other.totalValue != null)
				return false;
		} else if (!totalValue.equals(other.totalValue))
			return false;
		return true;
	}

}