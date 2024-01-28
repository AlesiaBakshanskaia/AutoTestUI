package org.homeWork2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StudentPage {
    @FindBy(xpath = "//table[@aria-label='Dummies list']/tbody/tr")
    private List<WebElement> rowsInDummiesList;

    public StudentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private RowDummiesList getRowByID(String id) throws InterruptedException {

        Thread.sleep(3000L);

        return rowsInDummiesList.stream().map(RowDummiesList::new)
                .filter(row -> row.getIdDummy().equals(id)).findFirst().orElseThrow();
    }

    public void openEditingDummyById(String id) throws InterruptedException {
        getRowByID(id).clickEditButton();

    }

    public String getNameDummyById(String id) throws InterruptedException {
        return getRowByID(id).getNameDummy();
    }

    public void openCredentialsModalById(String id) throws InterruptedException {
        getRowByID(id).clickCredentialButton();
    }

}
