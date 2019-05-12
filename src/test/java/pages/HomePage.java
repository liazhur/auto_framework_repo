package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	// *********Constructor*********
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// *********Page Variables*********
//	String baseURL = "http://automationpractice.com";

	// *********Web Elements*********
//	String signInButtonClass = "btnSignIn";// !!delete
	@FindBy(css = "a[title='View my shopping cart']")
	private WebElement cartWebEl;

	// *********Page Methods*********
//	public String getURL() {
//		return baseURL;
//	}

	public WebElement getCartWebElement() {
		return cartWebEl;
	}

}
