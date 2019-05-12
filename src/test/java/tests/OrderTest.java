package tests;

import java.lang.reflect.Method;

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
import pages.products.Products;
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

	@Test(priority = 0, description = "Go to url")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: ----.")
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

		// *************PAGE METHODS********************
		// Open HomePage
		Log.info("Opening Store website.");
		basicStep.goToURL(StoreProperties.URL);

		basicStep.selectSubMenu(Tab.WOMEN, SubMenu.SUMMER_DRESSES);
		basicStep.goToView(View.GRID);
		basicStep.quickViewProduct(Products.PRINTED_CHIFFON_DRESS);

		fillFormStep.selectSize("M");
		fillFormStep.addToCart();
		fillFormStep.contShopBtnClick();

		basicStep.goToCart();
		purchaseStep.proceedCheckout();

		purchaseStep.enterEmailCreateAccount(data.getEmail());

		fillFormStep.registerPersonalInfo(data);
		fillFormStep.proceedToCheckout();

		System.out.println("not end");
	}

}
