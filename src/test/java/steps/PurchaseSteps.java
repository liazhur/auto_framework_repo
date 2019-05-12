package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.MainHeaderAbstractPage;
import pages.checkout.SignInCreateAccountTabPage;
import pages.checkout.SummaryTabPage;

public class PurchaseSteps extends MainHeaderAbstractPage {

	public PurchaseSteps(WebDriver driver) {
		super(driver);
	}

	public PurchaseSteps(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	@Step("Click 'Proceed to checkout' button")
	public void proceedCheckout() {
		SummaryTabPage checkoutPage = new SummaryTabPage(driver, wait);
		checkoutPage.getProceedCheckoutBtn().click();
	}

	@Step("Enter email and create an account")
	public void enterEmailCreateAccount(String emailAddress) {
		SignInCreateAccountTabPage signInPage = new SignInCreateAccountTabPage(driver, wait);
		signInPage.getEmailTextBox().sendKeys(emailAddress);
		signInPage.getCreateAnAccountBtn().click();
	}

}
