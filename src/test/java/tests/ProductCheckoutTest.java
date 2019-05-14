package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.SubMenu;
import pages.checkout.UserData;
import pages.products.Product;
import pages.subcategories.View;
import pages.tabs.Tab;
import steps.BasicSteps;
import steps.FormFillSteps;
import steps.PurchaseSteps;
import utils.Log;
import utils.ExtentReports.ExtentTestManager;
import utils.Listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Functional Test")
@Feature("Checkout Tests")
public class ProductCheckoutTest extends BaseTest {

	@DataProvider(name = "products")
	public static Object[][] getProductsMap() {
		return new Object[][] { { Tab.WOMEN, SubMenu.SUMMER_DRESSES, "Printed Chiffon Dress", "M" } };
	}

	@Test(priority = 1, dataProvider = "products", description = "Basic checkout flow")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: basic flow of selecting a product, registering an account and proceeding through checkout.")
	@Story("Automate scenario: selecting product flow")
	public void productCheckoutScenario(Tab tab, SubMenu subMenu, String productName, String size)
			throws InterruptedException {
//		Log.info(method.getName() + " test is starting.");

		// ExtentReports Description
		ExtentTestManager.getTest().setDescription("Product Checkout Flow Scenario");

		// *************PAGE INSTANTIATIONS*************
		BasicSteps basicStep = new BasicSteps(driver, wait);
		FormFillSteps fillFormStep = new FormFillSteps(driver, wait);
		PurchaseSteps purchaseStep = new PurchaseSteps(driver);
		UserData data = new UserData();
		Product productExpected = new Product();
		Product productActual = new Product();

		// *************STEP METHODS********************
		Log.info("Opening Store website.");
		basicStep.openHomePage();
		basicStep.selectSubMenu(tab, subMenu);
		basicStep.goToView(View.GRID);
		basicStep.quickViewProduct(productName);

		fillFormStep.selectSize(size);
		fillFormStep.addToCart();
		fillFormStep.contShopBtnClick();
		basicStep.goToCart();

		purchaseStep.verifyProductSummary(productName, size, productExpected);

		purchaseStep.proceedCheckout();
		purchaseStep.enterEmailCreateAccount(data.getEmail());
		purchaseStep.registerPersonalInfo(data);
		purchaseStep.proceedToCheckout();
		purchaseStep.agreeTermsOfServiceProceed();
		purchaseStep.getProductFromPaymentTab(productActual);

		purchaseStep.verifyProductPurchase(productExpected, productActual);
	}

}
