package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage{

    //*********Constructor*********
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String usenameId = "username";
    String passwordId = "password";
    String loginButtonId = "login_btn";
    String errorMessageUsernameXpath = "//div[@class='proton-notification-template cg-notify-message notification-danger cg-notify-message-center']";
    String errorMessagePasswordXpath = "//div[@class='proton-notification-template cg-notify-message notification-danger cg-notify-message-center']";
    
    //*********Page Methods*********

    public void loginToN11 (String username, String password){
        //Enter Username(Email)
        writeText(By.id(usenameId),username);
        //Enter Password
        writeText(By.id(passwordId), password);
        //Click Login Button
        click(By.id(loginButtonId));
    }

    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorMessageUsernameXpath)), expectedText);
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedText);
    }
    
    public void verifyURLPage(String expectedURL) {
    	Assert.assertEquals(urlText(), expectedURL);
    }

}
