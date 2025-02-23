package pageClass;


import BaseClass.pushpendraWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createAccount extends pushpendraWindow {

    // Constructor
    public void CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    // Google Button पर Click करें
    public void clickOnGoogle() throws InterruptedException {
        WebElement googleButton = driver.findElement(By.xpath("//span[text()=\"Google\"]"));
        googleButton.click();
        Thread.sleep(3000);
    }

    // Google Login Window पर Email डालें
    public void enterEmailInGoogleLogin(String email) throws InterruptedException {
        switchToWindow(1); // Child Window पर जाएं

        WebElement emailField = driver.findElement(By.xpath("//input[@id=\"identifierId\"]"));
        emailField.sendKeys(email);
        Thread.sleep(2000);

        
    }
}
