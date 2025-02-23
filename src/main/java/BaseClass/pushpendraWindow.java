package BaseClass;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class pushpendraWindow {
	
	
	public WebDriver driver;
	public String[] handlesArray;

	@BeforeTest
	public void lounchChrome()

	{

		String path = "C:\\Users\\Admin\\eclipse-workspace\\PushpendraTestingBaba\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		// वेबसाइट खोलें
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
		driver.manage().window().maximize();
	}

	public void switchToWindow(int index) {
		Set<String> windowHandles = driver.getWindowHandles();
		handlesArray = windowHandles.toArray(new String[0]); // Global Variable Initialize किया गया
		if (index < handlesArray.length) {
			driver.switchTo().window(handlesArray[index]);
			System.out.println("Switched to Window: " + driver.getTitle());
		} else {
			System.out.println("Invalid window index: " + index);
		}
	}

	public void handleAlert(boolean accept) {
		Alert alert = driver.switchTo().alert();
		if (accept) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}

	@Test(priority = 1)

	public void clickOnGoogle() throws InterruptedException

	{

		WebElement clickOnGoogle = driver.findElement(By.xpath("//span[text()=\"Google\"]"));

		clickOnGoogle.click();

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void switchWindow() throws Exception {

		switchToWindow(1);

		WebElement emil = driver.findElement(By.xpath("//input[@id=\"identifierId\"]"));

	}

	@Test(priority = 3)
	public void putDetails()

	{

		switchToWindow(0);

		WebElement name = driver.findElement(By.xpath("//input[@id=\"name\"]"));

		name.sendKeys("pushpendra");
	}


	@AfterTest
	public void tearDown()

	{

		driver.close();

	}

}
