package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    String usenameId = "id_username";
    String passwordId = "id_password";
    String loginButtonId = "login_btn";
    String errorMessageUsernameXpath = "/html/body/div/div/div[2]/form/div[1]";
    String errorMessagePasswordXpath = "/html/body/div/div/div[2]/form/div[1]";
    
    //*********Page Methods*********

    public void login (String username, String password){
        //Enter Username(Email)
        writeText(By.id(usenameId),username);
        //Enter Password
        writeText(By.id(passwordId), password);
        //Click Login Button
        click(By.xpath("/html/body/div/div/div[2]/form/button"));
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
