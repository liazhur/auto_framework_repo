package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class SignInCreateAccountTabPage extends BasePage {

	@FindBy(id = "email_create")
	private WebElement emailTextBox;

	@FindBy(css = "button[id='SubmitCreate']")
	private WebElement createAccountBtn;

	public SignInCreateAccountTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	public WebElement getCreateAnAccountBtn() {
		return createAccountBtn;
	}

}
