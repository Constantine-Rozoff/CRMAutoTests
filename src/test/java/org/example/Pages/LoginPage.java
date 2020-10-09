package org.example.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwdField;

    @FindBy(xpath = "//span[contains(text(), 'Login')]")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[contains(text(), 'Username or password is incorrect.')]")
    private WebElement credentialsError;

    @FindBy(xpath = "//div[contains(text(), ' Username is required ')]")
    private WebElement usernameRequired;

    @FindBy(xpath = "//div[contains(text(), 'Password is required')]")
    private WebElement passwordRequired;

    @FindBy(xpath = "//div[contains(text(), 'LOGIN TO YOUR ACCOUNT')]")
    private WebElement loginScreen;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void findElementCredError() {credentialsError.isDisplayed();}

    public void findElementUsernameRequired() {usernameRequired.isDisplayed();}

    public void findElementPasswordRequired() {passwordRequired.isDisplayed();}

    public String loginScreen() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'LOGIN TO YOUR ACCOUNT')]")));
        return loginScreen.getText();
    }

    public String credError() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Username or password is incorrect.')]")));
        return credentialsError.getText();
    }
}
