package org.example.LoginTests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.example.Pages.LoginPage;
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
public class LoginTestWithInvalidLoginAndPassword {

    @DataProvider
    public static Object[][] sumTestData() {
        return new Object[][]{
                {"ggggggg", "hhhhhhhh"},
                {"", "password"},
                {"      ", "password"},
                {"login", ""},
                {"", ""}
        };
    }

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
    @UseDataProvider("sumTestData")
    public void loginTest(String a, String b) {
        loginPage.inputLogin(ConfProperties.getProperty(a));
        loginPage.inputPasswd(ConfProperties.getProperty(b));
        loginPage.clickLoginBtn();
        //loginPage.findElementCredError();
        //String usernameRequired = loginPage.;
        //Assert.assertEquals("Username is required", usernameRequired);
    }

    @AfterClass
    public static void tearDowm () {
        driver.quit();
    }
}
