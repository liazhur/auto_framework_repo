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
import steps.HomePageSteps;
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
		HomePageSteps homePage = new HomePageSteps(driver, wait);

		// *************PAGE METHODS********************
		// Open HomePage
		Log.info("Opening Store website.");
		homePage.goToURL(StoreProperties.URL);
	}

}
