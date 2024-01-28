package org.homeWork2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditingDummyPage {
    @FindBy(xpath = "//form[@id='upsert-item']/div[1]/label/input")
    WebElement firstNameField;
    @FindBy(xpath = "//form[@id='upsert-item']/div[2]/label/input")
    WebElement lastNameField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;
    @FindBy(xpath = "//button[@data-mdc-dialog-action='close']")
    WebElement closButton;
    private final WebDriverWait wait;

    public EditingDummyPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void editDummyName(String firstName, String lastName) throws InterruptedException {
        Thread.sleep(2000L);
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        closButton.click();
    }
}
