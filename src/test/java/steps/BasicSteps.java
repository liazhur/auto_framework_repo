package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.HomePage;
import pages.MainHeaderAbstractPage;
import pages.SubMenu;
import pages.checkout.SummaryTabPage;
import pages.subcategories.View;
import pages.tabs.Tab;
import pages.tabs.TabsAbstractPage;
import utils.Log;
import utils.StoreProperties;

public class BasicSteps extends MainHeaderAbstractPage {

	public BasicSteps(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	@Step("Go to Home Page")
	public void openHomePage() {
		driver.get(StoreProperties.URL);
		Log.info("Go to Home Page");
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
	public void openQuickViewProduct(String productName) {
		quickViewProduct(productName);
		Log.info("Quick view oppened");
	}

	@Step("Go to Cart")
	public SummaryTabPage openCart() {
		HomePage homePage = new HomePage(driver, wait);
		homePage.getCartWebElement().click();
		Log.info("Go to Cart");
		return new SummaryTabPage(driver, wait);
	}
}
