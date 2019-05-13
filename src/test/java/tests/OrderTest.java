package tests;

import java.lang.reflect.Method;

import org.testng.Assert;
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
import utils.StoreProperties;
import utils.ExtentReports.ExtentTestManager;
import utils.Listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Functional Test")
@Feature("Order Tests")
public class OrderTest extends BaseTest {

	@Test(priority = 1, description = "Basic checkout flow")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: basic flow of selecting a product, registering an account and proceeding through checkout.")
	@Story("Automate scenario: selecting product flow")
	public void productFlowScenario(Method method) throws InterruptedException {
		Log.info(method.getName() + " test is starting.");

		// ExtentReports Description
		ExtentTestManager.getTest().setDescription("Product Flow Scenario");

		// *************PAGE INSTANTIATIONS*************
		BasicSteps basicStep = new BasicSteps(driver, wait);
		FormFillSteps fillFormStep = new FormFillSteps(driver, wait);
		PurchaseSteps purchaseStep = new PurchaseSteps(driver);
		UserData data = new UserData();
		Product productExpected = new Product();
		Product productActual = new Product();

		// *************STEP METHODS********************
		Log.info("Opening Store website.");
		basicStep.goToURL(StoreProperties.URL);
		basicStep.selectSubMenu(Tab.WOMEN, SubMenu.SUMMER_DRESSES);
		basicStep.goToView(View.GRID);
		basicStep.quickViewProduct(productExpected.getProductName());

		fillFormStep.selectSize(productExpected.getSize());
		fillFormStep.addToCart();
		fillFormStep.contShopBtnClick();
		basicStep.goToCart();

		String productDescription = purchaseStep.getProductDescriptionFromSummaryTabPage(productExpected);

		Assert.assertTrue(productDescription.contains(productExpected.getProductName()),
				"Summary Tab Page doesn't contain product name " + productExpected.getProductName());

		Assert.assertTrue(productDescription.contains(productExpected.getSize()),
				"Summary Tab Page doesn't contain product size " + productExpected.getSize());

		purchaseStep.proceedCheckout();
		purchaseStep.enterEmailCreateAccount(data.getEmail());
		purchaseStep.registerPersonalInfo(data);
		purchaseStep.proceedToCheckout();
		purchaseStep.agreeTermsOfServiceProceed();
		purchaseStep.getProductFromPaymentTab(productActual);

		Assert.assertEquals(productActual.getTotalProducts(), productExpected.getTotalProducts(),
				"Total Products value is incorrect");
		Assert.assertEquals(productActual.getTotalShippingValue(), productExpected.getTotalShippingValue(),
				"Shipping Value is incorrect");
		Assert.assertEquals(productActual.getTotalValue(), productExpected.getTotalValue(), "Total Value is incorrect");
		Assert.assertTrue(productActual.getTableValues().containsAll(productExpected.getTableValues()),
				"Product Table Values are incorrect");
	}

}
