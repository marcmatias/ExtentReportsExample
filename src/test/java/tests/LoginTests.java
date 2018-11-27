package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;

public class LoginTests extends BaseTest {

    // Extra information:
    // 1) @BeforeClass we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration
    //    Homepage homepage = new HomePage(driver,wait);
    // 3) super () method in page class transfer the driver and wait variables values to the BasePage class.

    @Test (priority = 0, description="Cenário de login inválido com username e password errados.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("Test if message: 'Incorrect login credentials. Please try again', is printed.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
//        Open N11 LoginPage
        homePage.goToN11();


        //Login to N11
        loginPage.loginToN11("asffadm@protonmail.com", "X123456");

        //*************ASSERTIONS***********************
        Thread.sleep(2000);
        loginPage.verifyLoginPassword(("Incorrect login credentials. Please try again"));
    }

    @Test (priority = 1, description="Cenário de login inválido com username e password em branco.")
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("Test if message: 'Please enter your username and password.' is printed.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        homePage.goToN11();
        loginPage.loginToN11("","");

        //*************ASSERTIONS***********************
        Thread.sleep(2000);
        loginPage.verifyLoginUserName("Please enter your username and password");
        loginPage.verifyLoginPassword("Please enter your username and password");
    }

    @Test (priority = 2, description="Cenário de login Válido com username e password corretos.")
    public void validLoginTest_ValidUserNameValidPassword () throws InterruptedException {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        homePage.goToN11();

        //Login to N11
        loginPage.loginToN11("x@protonmail.com", "12345");
        
        //Verify logon page
        Thread.sleep(2000);
        loginPage.verifyURLPage("https://mail.protonmail.com/inbox");

    }
    
}
