package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class SignInPersonalInfoTabPage extends BasePage {

	@FindBy(id = "customer_firstname")
	private WebElement firstNameTextField;

	@FindBy(id = "customer_lastname")
	private WebElement lastNameTextField;

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "address1")
	private WebElement addressTextField;

	@FindBy(id = "passwd")
	private WebElement passTextField;

	@FindBy(id = "city")
	private WebElement cityTextField;

	@FindBy(id = "id_state")
	private WebElement stateDropDown;

	@FindBy(id = "postcode")
	private WebElement zipTextField;

	@FindBy(id = "id_country")
	private WebElement countryDropDown;

	@FindBy(id = "phone_mobile")
	private WebElement mPhoneTextField;

	@FindBy(id = "alias")
	private WebElement addressAliasTextField;

	@FindBy(id = "submitAccount")
	private WebElement registerBtn;

	public SignInPersonalInfoTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passTextField;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getStateDropDown() {
		return stateDropDown;
	}

	public WebElement getZipTextField() {
		return zipTextField;
	}

	public WebElement getCountryDropdown() {
		return countryDropDown;
	}

	public WebElement getMphoneTextField() {
		return mPhoneTextField;
	}

	public WebElement getAliasTextField() {
		return addressAliasTextField;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

}
