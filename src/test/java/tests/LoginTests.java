package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;

public class LoginTests extends BaseTest {
	
    @Test (priority = 2, description="Cenário de login inválido com username e password errados.")
    public void verifyLink () throws InterruptedException {

    	//ExtentReports Description
        ExtentTestManager.getTest().setDescription("Testa se o link que leva a tela de login esta funcional.");

    	//*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
       
        //*************PAGE METHODS********************
        homePage.goToHomePage();
        homePage.goToLoginPage();

        //Verify login
        Thread.sleep(2000);
        loginPage.verifyURLPage("http://marcmatias.pythonanywhere.com/login/");
    }
    
	@Test (priority = 0, description="Cenário de login inválido com username e password errados.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {

    	//ExtentReports Description
        ExtentTestManager.getTest().setDescription("Testa se mensagem de erro de login e exibida.");

    	//*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
       
        //*************PAGE METHODS********************
        homePage.goToHomePage();
        homePage.goToLoginPage();


        //Login
        loginPage.login("Test", "X123456");

        //*************ASSERTIONS***********************
        Thread.sleep(2000);
        loginPage.verifyLoginPassword(("or favor, entre com um usuário e senha corretos. Note que ambos os campos diferenciam maiúsculas e minúsculas."));
    }

    @Test (priority = 1, description="Cenário de login Válido com username e password corretos.")
    public void validLoginTest_ValidUserNameValidPassword () throws InterruptedException {
 
    	//ExtentReports Description
        ExtentTestManager.getTest().setDescription("Testa se login esta sendo efetuado corretamente.");

    	
    	//*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        
        //*************PAGE METHODS********************
        homePage.goToHomePage();
        homePage.goToLoginPage();

        //Login
        loginPage.login("admin", "Av123456");
        Thread.sleep(2000);
        
        //Verify login
        Thread.sleep(2000);
        loginPage.verifyURLPage("http://marcmatias.pythonanywhere.com/chart/");

    }
    
}
