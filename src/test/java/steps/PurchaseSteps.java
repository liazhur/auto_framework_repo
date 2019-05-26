package steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
import utils.WebDriverHelper;

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

		List<String> tableValues = summaryPage.getValuesFromTable(productExpected.getProductName());
		String totalProductsValue = summaryPage.getTotalProducts().getText();
		String totalShippingValue = summaryPage.getTotalShipping().getText();
		String totalValue = summaryPage.getTotalValue().getText();

		String description = summaryPage.getProductTable().getDescriptionUI((productExpected.getProductName()));
		String avail = summaryPage.getProductTable().getAvailUI((productExpected.getProductName()));
		String unitPrice = summaryPage.getProductTable().getUnitPriceUI((productExpected.getProductName()));
		String total = summaryPage.getProductTable().getTotalUI((productExpected.getProductName()));

		productExpected.getProductTable().setDescription(description);
		productExpected.getProductTable().setAvail(avail);
		productExpected.getProductTable().setUnitPrice(unitPrice);
		productExpected.getProductTable().setTotal(total);

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
		Log.info("Geting product description from Summary Page...");
		return getProductFromSummaryTab(productExpected).getTableValues().get(descriptionColumn).toString();
	}

	@Step("Enter email and create an account")
	public void enterEmailCreateAccount(String emailAddress) {
		SignInCreateAccountTabPage signInPage = new SignInCreateAccountTabPage(driver, wait);
		signInPage.getEmailTextBox().sendKeys(emailAddress);
		signInPage.getCreateAnAccountBtn().click();
		Log.info("Entered email and created an account");
	}

	@Step("Fill Personal Information")
	public SummaryTabPage registerPersonalInfo(UserData data) {
		SignInPersonalInfoTabPage persInfPage = new SignInPersonalInfoTabPage(driver, wait);
		WebDriverHelper.waitForElementVisibility(driver, persInfPage.getFirstNameTextField(), 10);
		persInfPage.getFirstNameTextField().sendKeys(data.getFirstName());
		persInfPage.getLastNameTextField().sendKeys(data.getLastName());
		persInfPage.getPasswordTextField().sendKeys(data.getPassw());
		persInfPage.getCityTextField().sendKeys(data.getCity());
		persInfPage.getAddressTextField().sendKeys(data.getAddress());

		Select select = new Select(persInfPage.getStateDropDown());
		select.selectByVisibleText(data.getState());

		persInfPage.getZipTextField().sendKeys(data.getZip());
		persInfPage.getMphoneTextField().sendKeys(data.getMobile());
		persInfPage.getAliasTextField().clear();
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
		Log.info("Agreed to 'Terms of service' and Clicked 'Proceed'");
		return new PaymentTabPage(driver, wait);
	}

	@Step("Get Product values from 'Payment' tab")
	public Product getProductFromPaymentTab(Product actualProduct, String productName) {
		PaymentTabPage paymentTabPage = new PaymentTabPage(driver);
		List<String> actualValuesList = paymentTabPage.getValuesFromTable(productName);

		actualProduct.setProductName(productName);

		String totalProducts = paymentTabPage.getTotalProducts().getText();
		String totalShipping = paymentTabPage.getTotalShipping().getText();
		String totalGeneral = paymentTabPage.getTotalValue().getText();

		String description = paymentTabPage.getProductTable().getDescriptionUI(productName);
		String avail = paymentTabPage.getProductTable().getAvailUI(productName);
		String unitPrice = paymentTabPage.getProductTable().getUnitPriceUI(productName);
		String total = paymentTabPage.getProductTable().getTotalUI(productName);

		actualProduct.getProductTable().setDescription(description);
		actualProduct.getProductTable().setAvail(avail);
		actualProduct.getProductTable().setUnitPrice(unitPrice);
		actualProduct.getProductTable().setTotal(total);

		actualProduct.setTableValues(actualValuesList);
		actualProduct.setTotalProducts(totalProducts);
		actualProduct.setTotalShippingValue(totalShipping);
		actualProduct.setTotalValue(totalGeneral);
		Log.info("Got Product values from 'Payment' tab");
		return actualProduct;
	}

	@Step("Verify Product Summary information")
	public void verifyProductSummary(String productName, String size, Product productExpected) {
		productExpected.setProductName(productName);

		String avail = productExpected.getProductTable().getAvailUI(productName);
		productExpected.getProductTable().setAvail(avail);

		String productDescription = getProductDescriptionFromSummaryTabPage(productExpected);

		Assert.assertTrue(productDescription.contains(productName),
				"Summary Tab Page doesn't contain product name " + productName);

		Assert.assertTrue(productDescription.contains(size), "Summary Tab Page doesn't contain product size " + size);
	}

	@Step("Verify Product Purchase information")
	public void verifyProductPurchase(Product productExpected, Product productActual) {
		Assert.assertEquals(productActual.getTotalProducts(), productExpected.getTotalProducts(),
				"Total Products value is incorrect");
		Assert.assertEquals(productActual.getTotalShippingValue(), productExpected.getTotalShippingValue(),
				"Shipping Value is incorrect");
		Assert.assertEquals(productActual.getTotalValue(), productExpected.getTotalValue(), "Total Value is incorrect");

		Assert.assertTrue(productActual.getTableValues().containsAll(productExpected.getTableValues()),
				"Product Table Values are incorrect");

//		Assert.assertEquals(productActual, productExpected, "Products value is incorrect");
	}

}
