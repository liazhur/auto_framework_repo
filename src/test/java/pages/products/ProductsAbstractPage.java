package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MainHeaderAbstractPage;
import pages.checkout.CartQuickViewPage;

public class ProductsAbstractPage extends MainHeaderAbstractPage {

	private static final String buyBlockCss = "[id='buy_block']";

	@FindBy(css = buyBlockCss + " .selector.hover[id ='uniform-group_1']")
	private WebElement sizeDropdwn;

	@FindBy(css = buyBlockCss + " [id='add_to_cart']")
	private WebElement addToCartBtn;

	public ProductsAbstractPage(WebDriver driver) {
		super(driver);
	}

	public ProductsAbstractPage(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	public void selectSize(Products size) {
		WebElement dropdown = driver.findElement(By.name("group_1"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(size.getName());

	}

	public CartQuickViewPage addToCart() {
		addToCartBtn.click();
//		WebDriverHelper.waitForElementInVisibility(driver, addToCartBtn, 10);
		return new CartQuickViewPage(driver, wait);
	}

}
