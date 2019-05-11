package pages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import pages.product.DressesPage;
import pages.product.TShirtsPage;
import pages.product.WomenPage;
import utils.WebDriverHelper;

public class MainHeaderAbstractPage extends BasePage {
	protected final String mainMenuXpath = "//ul[@id='menu-main-menu']";
	private final String tabXpath = mainMenuXpath + "//a[text()='%s']";

	public MainHeaderAbstractPage(WebDriver driver) {
		super(driver);
	}

	public MainHeaderAbstractPage switchOnTab(Tab tab) {
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

	private void moveMouseToTab(Tab tab) {
		if (tab.getParentTab() == null) {
			WebDriverHelper.moveToElement(driver, WebDriverHelper.findElementByXpath(driver,
					String.format(tabXpath, tab.getName()), this.ELEMENT_APPEAR_TIMEOUT));
		} else
			moveMouseToTab(tab.getParentTab());
	}

}
