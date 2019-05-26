package pages.checkout;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ProductTable extends BasePage {

	@FindBy(id = "cart_summary")
	private WebElement table;

	@FindBy(id = "total_price")
	private WebElement totalValue;

	@FindBy(id = "total_shipping")
	private WebElement totalShipping;

	@FindBy(id = "total_product")
	private WebElement totalProducts;

	private String description;
	private String avail;
	private String unitPrice;
	private String qty;
	private String total;

	public ProductTable(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public ProductTable(WebDriver driver) {
		super(driver);
	}

	public WebElement getTable() {
		return table;
	}

	public WebElement getTotalShipping() {
		return totalShipping;
	}

	public WebElement getTotalValue() {
		return totalValue;
	}

	public WebElement getTotalProducts() {
		return totalProducts;
	}

	public String getDescription() {
		return description;
	}

	public String getDescriptionUI(String productName) {
		String id = getProductId(productName);
		String css = String.format("#%s" + " .cart_description", id);
		description = driver.findElement(By.cssSelector(css)).getText();
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvail() {
		return avail;
	}

	public String getAvailUI(String productName) {
		String id = getProductId(productName);
		return driver.findElement(By.cssSelector(String.format("#%s" + " .cart_avail span", id))).getText();
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public String getUnitPriceUI(String productName) {
		String id = getProductId(productName);
		return driver.findElement(By.cssSelector(String.format("#%s" + " .cart_unit", id))).getText();
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getQty() {
		return qty;
	}

	public String getQtyUI(String productName) {
		String id = getProductId(productName);
		return driver.findElement(By.cssSelector(String.format("#%s" + " .cart_quantity", id))).getText();
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getTotal() {
		return total;
	}

	public String getTotalUI(String productName) {
		String id = getProductId(productName);
		return driver.findElement(By.cssSelector(String.format("#%s" + " .cart_total .price", id))).getText();
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<String> getValuesFromTable(String productName) {
		List<WebElement> tableRows = getTable().findElements(By.tagName("tr"));
		List<WebElement> cols = new ArrayList<WebElement>();
		List<String> values = new ArrayList<String>();
//		for (int i = 0; i < tableRows.size(); i++) {
//			WebElement row = tableRows.get(i);
//		}
		for (int i = 0; i < tableRows.size(); i++) {
			cols = tableRows.get(i).findElements(By.tagName("td"));
		}

		for (int j = 0; j < cols.size(); j++) {
			String el = cols.get(j).getText();
			values.add(el);
		}

//		getValueFromTable(productName);
		getProductId(productName);
		return values;
	}

	public void getValueFromTable(String productName) {
		List<WebElement> allColumnsInRow = driver.findElements(
				By.xpath(String.format("//table[@id='cart_summary']/tbody/tr/td[@class='%s']", "cart_description")));
		for (WebElement e : allColumnsInRow) {
			System.out.println(e.getText());
		}
	}

	public String getProductId(String productName) {
		String id = "";
		List<WebElement> allColumnsInRow = driver.findElements(By.xpath(String
				.format("//*[contains(@class, '%s') and descendant::*[contains(., '%s')]]", "cart_item", productName)));

		for (WebElement e : allColumnsInRow) {
			if (e.getText().contains(productName)) {
				id = e.getAttribute("id");
			}
		}
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avail == null) ? 0 : avail.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((table == null) ? 0 : table.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((totalProducts == null) ? 0 : totalProducts.hashCode());
		result = prime * result + ((totalShipping == null) ? 0 : totalShipping.hashCode());
		result = prime * result + ((totalValue == null) ? 0 : totalValue.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		ProductTable other = (ProductTable) obj;
		if (avail == null) {
			if (other.avail != null)
				return false;
		} else if (!avail.equals(other.avail))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (totalProducts == null) {
			if (other.totalProducts != null)
				return false;
		} else if (!totalProducts.equals(other.totalProducts))
			return false;
		if (totalShipping == null) {
			if (other.totalShipping != null)
				return false;
		} else if (!totalShipping.equals(other.totalShipping))
			return false;
		if (totalValue == null) {
			if (other.totalValue != null)
				return false;
		} else if (!totalValue.equals(other.totalValue))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

}
