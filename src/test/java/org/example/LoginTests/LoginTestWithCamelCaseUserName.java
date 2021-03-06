package org.example.LoginTests;

import org.example.Properties.ConfProperties;
import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestWithCamelCaseUserName {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login").toUpperCase());
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getServerName();
        Assert.assertEquals("QA SERVER", user);
    }

    @AfterClass
    public static void tearDowm() {
        profilePage.userLogout();
        String loginScreen = loginPage.loginScreen();
        Assert.assertEquals("LOGIN TO YOUR ACCOUNT", loginScreen);
        driver.quit();
    }
}
