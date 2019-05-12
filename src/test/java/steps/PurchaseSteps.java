package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.MainHeaderAbstractPage;
import pages.checkout.AddressTabPage;
import pages.checkout.PaymentTab;
import pages.checkout.ShippingTabPage;
import pages.checkout.SignInCreateAccountTabPage;
import pages.checkout.SignInPersonalInfoTabPage;
import pages.checkout.SummaryTabPage;
import pages.checkout.UserData;

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

	@Step("Fill Personal Information")
	public SummaryTabPage registerPersonalInfo(UserData data) {
		SignInPersonalInfoTabPage persInfPage = new SignInPersonalInfoTabPage(driver, wait);
		persInfPage.getFirstNameTextField().sendKeys(data.getFirstName());
		persInfPage.getLastNameTextField().sendKeys(data.getLastName());
		persInfPage.getCityTextField().sendKeys(data.getCity());
		persInfPage.getAddressTextField().sendKeys(data.getAddress());

		Select select = new Select(persInfPage.getStateDropDown());
		select.selectByVisibleText(data.getState());

		persInfPage.getZipTextField().sendKeys(data.getZip());
		persInfPage.getMphoneTextField().sendKeys(data.getMobile());
		persInfPage.getAliasTextField().sendKeys(data.getAlias());
		persInfPage.getRegisterBtn().click();
		return new SummaryTabPage(driver, wait);
	}

	@Step("Proceed to checkout from Address Tab")
	public ShippingTabPage proceedToCheckout() {
		AddressTabPage addressTabPage = new AddressTabPage(driver, wait);
		addressTabPage.getProceedCheckoutBtn().click();
		return new ShippingTabPage(driver, wait);
	}

	@Step("Agree to 'Terms of service' and Click 'Proceed'")
	public PaymentTab agreeTermsOfServiceProceed() {
		ShippingTabPage shippingPage = new ShippingTabPage(driver, wait);

		if (!shippingPage.getTermsOfServiceCheckBox().isSelected()) {
			shippingPage.getTermsOfServiceCheckBox().click();
		}
		shippingPage.getProceedCheckoutBtn().click();
		return new PaymentTab(driver, wait);
	}

	@Step("Confirm the correct order on 'Payment' tab")
	public boolean verifyOrderOnPaymentTab() {

		return false;

	}

}
