package org.homeWork2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CredentialsModalWindowPage {
    @FindBy(xpath = "//h2[@id='simple-title']")
    WebElement headerModalWindow;
    @FindBy(xpath = "//div[@id='simple-content']")
    WebElement contentModalWindow;

    @FindBy(xpath = "//button[@data-mdc-dialog-action='closeShowCredentials']")
    WebElement closeModalWindowButton;
    private final WebDriverWait wait;

    public CredentialsModalWindowPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public String getTextHeaderModalWindow() {
        return wait.until(ExpectedConditions.visibilityOf(headerModalWindow)).getText();
    }

    public String getTextCloseModalWindowButton() {
        return wait.until(ExpectedConditions.visibilityOf(closeModalWindowButton)).getText();
    }

    public Boolean checkTextInContentModalWindow(String text) {
        String textContent = wait.until(ExpectedConditions.visibilityOf(contentModalWindow)).getText();
        System.out.println(textContent);
        return textContent.contains(text);
    }
}
