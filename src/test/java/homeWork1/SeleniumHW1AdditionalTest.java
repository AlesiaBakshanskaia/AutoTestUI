package homeWork1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SeleniumHW1AdditionalTest extends AdditionalTaskAbstractTest {


    @Test
    void dragAndDrop() throws InterruptedException {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        Actions actions = new Actions(driver);
        WebElement picture = wait.until(
                webDriver -> webDriver.findElement(By.xpath("//*[@alt='On top of Kozi kopka']")));
        WebElement basket = driver.findElement(By.id("trash"));
        getScreenShot(driver, "src/test/resources/screenshotBeforeDAD.png");
        actions.dragAndDrop(picture, basket).build().perform();
        Thread.sleep(2000L);
        getScreenShot(driver, "src/test/resources/screenshotAfterDAD.png");
        int amountPicturesInGallery = driver.findElements(By.xpath(
                        "//ul[@id='gallery']//li[@class='ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle']"))
                .size();
        Assertions.assertEquals(3, amountPicturesInGallery);
    }
}
