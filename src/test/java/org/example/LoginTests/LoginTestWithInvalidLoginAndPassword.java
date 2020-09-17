package org.example.LoginTests;

import org.example.Pages.LoginPage;
import org.example.Properties.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestWithInvalidLoginAndPassword {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("invalidLogin"));
        loginPage.inputPasswd(ConfProperties.getProperty("invalidPassword"));
        loginPage.clickLoginBtn();
        loginPage.findElementCredError();
    }

    @AfterClass
    public static void tearDowm () {
        driver.quit();
    }
}
