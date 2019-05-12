package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.MainHeaderAbstractPage;
import pages.checkout.CartQuickViewPage;
import pages.products.Products;
import pages.products.ProductsAbstractPage;
import utils.WebDriverHelper;

public class FormFillSteps extends MainHeaderAbstractPage {

	public FormFillSteps(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	public FormFillSteps(WebDriver driver) {
		super(driver);
	}

	@Step("Select size")
	public void selectSize(Products size) {
		ProductsAbstractPage viewPage = new ProductsAbstractPage(driver);
		viewPage.selectSize(size);
	}

	@Step("Add to cart")
	public CartQuickViewPage addToCart() {
		ProductsAbstractPage viewPage = new ProductsAbstractPage(driver, wait);
		viewPage.addToCart();
		return new CartQuickViewPage(driver, wait);
	}

	@Step("Click Continue Shopping Button")
	public void contShopBtnClick() {
		CartQuickViewPage cPage = new CartQuickViewPage(driver, wait);
		WebDriverHelper.waitForElementVisibility(driver, cPage.getContinueShoppingBtn(), 10);
		cPage.getContinueShoppingBtn().click();
	}

}
