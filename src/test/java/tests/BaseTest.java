package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.
    	
        driver = new ChromeDriver();

        // Window
		driver.manage().window().setPosition(new Point(300,10));
		driver.manage().window().setSize(new Dimension(1500, 1000));
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }

}
