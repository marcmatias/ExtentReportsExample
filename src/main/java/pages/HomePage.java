package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "http://marcmatias.pythonanywhere.com/";
    //String baseURL = "http://marcmatias.pythonanywhere.com/login/";

    //*********Web Elements*********
    //String signInButtonClass = "btnSignIn";
    String signInButtonClass = "login_btn";


    //*********Page Methods*********

    //Go to Homepage
    public void goToHomePage (){
        driver.get(baseURL);
        driver.navigate().to(baseURL);
    }

    //Go to LoginPage
    public void goToLoginPage (){
        click(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li[7]/a"));
    }

}
