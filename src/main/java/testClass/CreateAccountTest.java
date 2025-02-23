package testClass;

import org.testng.annotations.Test;
import BaseClass.pushpendraWindow;
import pageClass.createAccount;

public class CreateAccountTest extends pushpendraWindow {
	
	CreateAccount createAccount = new CreateAccount();
	

    @Test(priority = 1)
    public void testGoogleLogin() throws InterruptedException {
      
        
       

//        createAccount.clickOnGoogle(); // ✅ Google Button पर Click करें
//        createAccount.enterEmailInGoogleLogin("pushpendra@gmail.com"); // ✅ Google Window में Email डालें
    }
}
