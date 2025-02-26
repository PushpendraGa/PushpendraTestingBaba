package pageClass;

import BaseClass.pushpendraWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createAccount extends pushpendraWindow {

	// Constructor to initialize elements
	public createAccount() {
		this.driver = driver;
		PageFactory.initElements(driver, this); // ✅ Initialize PageFactory
	}

	@FindBy(xpath = "//span[text()='Google']")
	WebElement googleButton;

	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement emailField;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	public void clickOnGoogle() throws InterruptedException {

		googleButton.click();
		Thread.sleep(3000);
	}

	public void enterEmailInGoogleLogin(String email) throws InterruptedException {

		switchToWindow(1);

		emailField.sendKeys(email);
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		switchToWindow(0);

		name.sendKeys("pushpendra");

	}
}
