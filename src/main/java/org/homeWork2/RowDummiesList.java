package org.homeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class RowDummiesList {
    private final WebElement root;

    public RowDummiesList(WebElement root) {
        this.root = root;
    }

    public String getIdDummy() {
        return root.findElement(By.xpath("./td[1]")).getText();
    }

    public String getNameDummy() {
        return root.findElement(By.xpath("./td[2]")).getText();
    }

    public void clickEditButton() {
        root.findElement(By.xpath("./td[7]/button[2]")).click();
    }

    public void clickCredentialButton() {

        root.findElement(By.xpath("./td[7]/button[1]")).click();
    }

}
