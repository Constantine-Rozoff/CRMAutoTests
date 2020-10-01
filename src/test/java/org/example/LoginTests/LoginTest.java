package org.example.LoginTests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.example.Properties.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(DataProviderRunner.class)
public class LoginTest {

    @DataProvider
    public static Object[][] sumTestData() {
        return new Object[][]{
                {"login"},
                {"loginCamelCase"}
        };
    }

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
    @UseDataProvider("sumTestData")
    public void loginTest(String a) {
        loginPage.inputLogin(ConfProperties.getProperty(a));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getServerName();
        Assert.assertEquals("QA SERVER", user);
        profilePage.userLogout();
    }

    @AfterClass
    public static void tearDowm () {
        //profilePage.userLogout();
        String loginScreen = loginPage.loginScreen();
        Assert.assertEquals("LOGIN TO YOUR ACCOUNT", loginScreen);
        driver.quit();
    }
}


