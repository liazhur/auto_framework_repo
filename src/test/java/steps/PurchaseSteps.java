package steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.MainHeaderAbstractPage;
import pages.checkout.AddressTabPage;
import pages.checkout.PaymentTabPage;
import pages.checkout.ShippingTabPage;
import pages.checkout.SignInCreateAccountTabPage;
import pages.checkout.SignInPersonalInfoTabPage;
import pages.checkout.SummaryTabPage;
import pages.checkout.UserData;
import pages.products.Product;
import utils.Log;

public class PurchaseSteps extends MainHeaderAbstractPage {

	int descriptionColumn = 1;

	public PurchaseSteps(WebDriver driver) {
		super(driver);
	}

	public PurchaseSteps(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	@Step("Get Product from Summary Tab Page")
	public Product getProductFromSummaryTab(Product productExpected) {
		SummaryTabPage summaryPage = new SummaryTabPage(driver);

		List<String> tableValues = summaryPage.getValuesFromTable();
		String totalProductsValue = summaryPage.getTotalProducts().getText();
		String totalShippingValue = summaryPage.getTotalShipping().getText();
		String totalValue = summaryPage.getTotalValue().getText();

		productExpected.setTableValues(tableValues);
		productExpected.setTotalProducts(totalProductsValue);
		productExpected.setTotalShippingValue(totalShippingValue);
		productExpected.setTotalValue(totalValue);
		return productExpected;
	}

	@Step("Click 'Proceed to checkout' button")
	public void proceedCheckout() {
		SummaryTabPage summaryPage = new SummaryTabPage(driver);
		summaryPage.getProceedCheckoutBtn().click();
		Log.info("Click 'Proceed to checkout' button");
	}

	@Step("Get product description from Summary Page")
	public String getProductDescriptionFromSummaryTabPage(Product productExpected) {
		return getProductFromSummaryTab(productExpected).getTableValues().get(descriptionColumn).toString();
	}

	@Step("Enter email and create an account")
	public void enterEmailCreateAccount(String emailAddress) {
		SignInCreateAccountTabPage signInPage = new SignInCreateAccountTabPage(driver, wait);
		signInPage.getEmailTextBox().sendKeys(emailAddress);
		signInPage.getCreateAnAccountBtn().click();
		Log.info("Enter email and create an account");
	}

	@Step("Fill Personal Information")
	public SummaryTabPage registerPersonalInfo(UserData data) {
		SignInPersonalInfoTabPage persInfPage = new SignInPersonalInfoTabPage(driver, wait);
		persInfPage.getFirstNameTextField().sendKeys(data.getFirstName());
		persInfPage.getLastNameTextField().sendKeys(data.getLastName());
		persInfPage.getPasswordTextField().sendKeys(data.getPassw());
		persInfPage.getCityTextField().sendKeys(data.getCity());
		persInfPage.getAddressTextField().sendKeys(data.getAddress());

		Select select = new Select(persInfPage.getStateDropDown());
		select.selectByVisibleText(data.getState());

		persInfPage.getZipTextField().sendKeys(data.getZip());
		persInfPage.getMphoneTextField().sendKeys(data.getMobile());
		persInfPage.getAliasTextField().sendKeys(data.getAlias());
		persInfPage.getRegisterBtn().click();
		Log.info("Personal Information successfully filled");
		return new SummaryTabPage(driver, wait);
	}

	@Step("Proceed to checkout from Address Tab")
	public ShippingTabPage proceedToCheckout() {
		AddressTabPage addressTabPage = new AddressTabPage(driver, wait);
		addressTabPage.getProceedCheckoutBtn().click();
		Log.info("Proceed to checkout from Address Tab");
		return new ShippingTabPage(driver, wait);
	}

	@Step("Agree to 'Terms of service' and Click 'Proceed'")
	public PaymentTabPage agreeTermsOfServiceProceed() {
		ShippingTabPage shippingPage = new ShippingTabPage(driver, wait);

		if (!shippingPage.getTermsOfServiceCheckBox().isSelected()) {
			shippingPage.getTermsOfServiceCheckBox().click();
		}
		shippingPage.getProceedCheckoutBtn().click();
		Log.info("Agreed to 'Terms of service' and Clicked 'Proceed");
		return new PaymentTabPage(driver, wait);
	}

	@Step("Get Product values from 'Payment' tab")
	public Product getProductFromPaymentTab(Product actualProduct) {
		PaymentTabPage paymentTabPage = new PaymentTabPage(driver);
		List<String> actualValuesList = paymentTabPage.getValuesFromTable();

		String totalProducts = paymentTabPage.getTotalProducts().getText();
		String totalShipping = paymentTabPage.getTotalShipping().getText();
		String totalGeneral = paymentTabPage.getTotalValue().getText();

		actualProduct.setTableValues(actualValuesList);
		actualProduct.setTotalProducts(totalProducts);
		actualProduct.setTotalShippingValue(totalShipping);
		actualProduct.setTotalValue(totalGeneral);
		return actualProduct;

	}

}
