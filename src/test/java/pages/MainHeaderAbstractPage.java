package pages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.products.ProductQuickViewPage;
import pages.subcategories.View;
import pages.tabs.DressesPage;
import pages.tabs.TShirtsPage;
import pages.tabs.Tab;
import pages.tabs.WomenPage;
import utils.WebDriverHelper;

public class MainHeaderAbstractPage extends BasePage {
	protected final String mainMenuXpath = "//div[@id='block_top_menu']";
	private final String tabXpath = mainMenuXpath + "//a[text()='%s']";
	private final String subMenuCss = "a[title='%s']";
	private final String viewCss = "a[title='%s']";

	public MainHeaderAbstractPage(WebDriver driver) {
		super(driver);
	}

	public MainHeaderAbstractPage switchTab(Tab tab) {
		Map<Tab, Supplier<MainHeaderAbstractPage>> tabs = new HashMap<Tab, Supplier<MainHeaderAbstractPage>>() {
			{
				put(Tab.WOMEN, () -> new WomenPage(driver));
				put(Tab.DRESSES, () -> new DressesPage(driver));
				put(Tab.TSHIRTS, () -> new TShirtsPage(driver));
			}
		};
		moveMouseToTab(tab);
		WebDriverHelper.findElementByXpath(driver, String.format(tabXpath, tab.getName()), this.PAGE_LOADING_TIMEOUT)
				.click();
		MainHeaderAbstractPage page = tabs.get(tab).get();
//		page.waitForPage();
		return page;
	}

	protected void moveMouseToTab(Tab tab) {
		WebDriverHelper.moveToElement(driver, WebDriverHelper.findElementByXpath(driver,
				String.format(tabXpath, tab.getName()), this.ELEMENT_APPEAR_TIMEOUT_LONG));
	}

	protected void selectSMenu(Tab tab, SubMenu sMenu) {
		moveMouseToTab(tab);
		WebDriverHelper.sleepSeconds(3);// TODO delete
		WebDriverHelper.moveToElementClick(driver, WebDriverHelper.findElementByCss(driver,
				String.format(subMenuCss, sMenu.getName()), this.ELEMENT_APPEAR_TIMEOUT_LONG));
	}

	public void toView(View view) {
		// TODO: verification if selected can be added
		WebDriverHelper.findElementByCss(driver, String.format(viewCss, view.getName()), this.ELEMENT_APPEAR_TIMEOUT)
				.click();
	}

	public ProductQuickViewPage quickViewProduct(String productName) {
		String prodImageCss = ".product_list.grid img[title = '%s']";
		WebElement el = WebDriverHelper.findElementByCss(driver, String.format(prodImageCss, productName),
				this.ELEMENT_APPEAR_TIMEOUT_LONG);
		WebDriverHelper.scrollToView(driver, el);
		WebDriverHelper.moveToElementClick(driver, WebDriverHelper.findElementByCss(driver,
				String.format(prodImageCss, productName), this.ELEMENT_APPEAR_TIMEOUT_LONG));
		return new ProductQuickViewPage(driver, wait);
	}

}
