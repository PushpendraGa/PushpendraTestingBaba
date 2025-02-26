package testClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.pushpendraWindow;
import pageClass.createAccount;

public class CreateAccountTest  extends pushpendraWindow{

	createAccount cclass;
	
	 @BeforeMethod
	    public void setUp() {
		         
	        cclass = new createAccount();  // ✅ Correct Initialization
	    }
	

   @Test(priority = 1)
   public void testGoogleLogin() throws InterruptedException {
     
     cclass.clickOnGoogle();  
     
     cclass.enterEmailInGoogleLogin("pushpendra");
      


   }
	
}
