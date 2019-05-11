package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.HomePage;

public class HomePageSteps extends HomePage {

	public HomePageSteps(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Go to Homepage
	@Step("Open URL Step...")
	public void goToURL(String url) {
		driver.get(url);
		// driver.navigate().to(baseURL)
	}

}
