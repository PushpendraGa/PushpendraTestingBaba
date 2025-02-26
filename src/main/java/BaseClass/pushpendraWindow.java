package BaseClass;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pushpendraWindow {

	public static WebDriver driver;
	public String[] handlesArray;
	
	
	

	@BeforeClass
	public void lounchChrome()

	{

//		String path = "C:\\Users\\Admin\\eclipse-workspace\\PushpendraTestingBaba\\driver\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", path);
		
		if (driver == null) {
            String browser = ConfigReader.getProperty("browser"); // ✅ Read browser from properties file
            String url = ConfigReader.getProperty("url");         // ✅ Read URL from properties file

            System.out.println("🔵 Launching Browser: " + browser);
            System.out.println("🌐 Opening URL: " + url);
            
           

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                    
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                    
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("❌ Invalid browser name in config.properties");
            }

            driver.manage().window().maximize();
            driver.get(url); // ✅ Load URL from properties file
        }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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

	@AfterClass
	public void tearDown()

	{

		driver.close();

		System.out.println("close driver");

	}
	
	

}
