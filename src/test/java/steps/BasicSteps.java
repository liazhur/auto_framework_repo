package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.HomePage;
import pages.MainHeaderAbstractPage;
import pages.SubMenu;
import pages.checkout.SummaryTabPage;
import pages.products.Products;
import pages.subcategories.View;
import pages.tabs.Tab;
import pages.tabs.TabsAbstractPage;
import utils.Log;

public class BasicSteps extends MainHeaderAbstractPage {

	public BasicSteps(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	// Go to Homepage
	@Step("Open URL Step: {url}")
	public void goToURL(String url) {
		driver.get(url);
		// driver.navigate().to(baseURL)
	}

	@Step("Switch to tab: {tab}")
	public TabsAbstractPage switchOnTab(Tab tab) {
		return (TabsAbstractPage) switchTab(tab);
	}

	@Step("Select tab: {tab} and submenu {sMenu}")
	public void selectSubMenu(Tab tab, SubMenu sMenu) {
		HomePage homePage = new HomePage(driver);
		selectSMenu(tab, sMenu);
		Log.info("Selected sub menu");
	}

	@Step("Go to View: {view}")
	public void goToView(View view) {
		toView(view);
		Log.info("Oppened view");

	}

	@Step("Open Quick view product")
	public void openQuickViewProduct(Products product) {
		quickViewProduct(product);
		Log.info("Quick view oppened");
	}

	@Step("Go to Cart")
	public SummaryTabPage goToCart() {
		HomePage homePage = new HomePage(driver, wait);
		homePage.getCartWebElement().click();
		Log.info("Go to Cart");
		return new SummaryTabPage(driver, wait);
	}
}
