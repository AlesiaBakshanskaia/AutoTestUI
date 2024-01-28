package org.homeWork2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement fieldLogin;
    @FindBy(css = "input[type='password']")
    private WebElement fieldPassword;
    @FindBy(className = "mdc-button__label")
    private WebElement buttonLogin;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void authorize(String login, String password) {
        fieldLogin.sendKeys(login);
        fieldPassword.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin)).click();
    }

}
