package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {
WebDriver driver;

	

	

	

	@FindBy(id="user-name")

	WebElement username;

	

	@FindBy(id="password")

	WebElement password;

	

	@FindBy(id="login-button")

	WebElement loginButton;

	

	public SauceDemoLoginPage(WebDriver driver) {

		this.driver = driver;

        PageFactory.initElements(driver, this);

    	

	}

	

	

	public void setUsername(String uname) {

		username.sendKeys(uname);

	}

	

	public void setPassword(String pwd) {

		password.sendKeys(pwd);

	}

	

	public void clickLoginButton() {

		loginButton.click();

	}

	

	public SauceDemoInventoryPage login(String username, String password) {

	

		setUsername(username);

		setPassword(password);

		clickLoginButton();

		return new SauceDemoInventoryPage(driver);

	}

	

	public String getTitle() {

		return driver.getTitle();

	}

}
