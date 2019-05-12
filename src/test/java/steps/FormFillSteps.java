package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.MainHeaderAbstractPage;
import pages.checkout.AddressTabPage;
import pages.checkout.CartQuickViewPage;
import pages.checkout.ShippingTabPage;
import pages.checkout.SignInPersonalInfoTabPage;
import pages.checkout.SummaryTabPage;
import pages.checkout.UserData;
import pages.products.ProductsAbstractPage;
import utils.WebDriverHelper;

public class FormFillSteps extends MainHeaderAbstractPage {

	public FormFillSteps(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	public FormFillSteps(WebDriver driver) {
		super(driver);
	}

	@Step("Select size")
	public void selectSize(String size) {
		ProductsAbstractPage viewPage = new ProductsAbstractPage(driver);
		viewPage.selectSize(size);
	}

	@Step("Add to cart")
	public CartQuickViewPage addToCart() {
		ProductsAbstractPage viewPage = new ProductsAbstractPage(driver, wait);
		viewPage.addToCart();
		return new CartQuickViewPage(driver, wait);
	}

	@Step("Click Continue Shopping Button")
	public void contShopBtnClick() {
		CartQuickViewPage cPage = new CartQuickViewPage(driver, wait);
		WebDriverHelper.waitForElementVisibility(driver, cPage.getContinueShoppingBtn(), 10);
		cPage.getContinueShoppingBtn().click();
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

	@Step("Agree to 'Terms of service' and Click 'Proceed ")
	public void agreeTermsOfServiceProceed() {
		ShippingTabPage shippingPage = new ShippingTabPage(driver, wait);
		shippingPage.getTermsOfServiceCheckBox().click();
		shippingPage.getProceedCheckoutBtn().click();

	}

}
