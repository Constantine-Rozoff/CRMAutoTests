package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[contains(text(), 'QA')]")
    private WebElement userMenu;

    @FindBy(xpath = "//span[contains(text(), 'Sign out')]")
    private WebElement logoutBtn;

    public String getUserName () {
      WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'QA')]")));
        String userName = userMenu.getText();
        return userName;
    }

    public void userLogout() {
        logoutBtn.click(); }
}
