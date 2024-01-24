import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;


public class SeleniumHW1Test {

    static WebDriver driver;
    private String myLogin = "LLLLLL56598";
    private String myPassword = "61249d71fc";
    static Wait<WebDriver> wait;

    @BeforeAll
    static void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        driver.get("https://test-stand.gb.ru/login");

    }

    @Test
    void createDummyAfterAuthorization() {
        WebElement fieldLogin = driver.findElement(By.xpath("//input[@type='text']"));
        fieldLogin.sendKeys(myLogin);
        WebElement fieldPassword = driver.findElement(By.cssSelector("input[type='password']"));
        fieldPassword.sendKeys(myPassword);
        WebElement buttonLogin = driver.findElement(By.className("mdc-button__label"));
        buttonLogin.click();

        WebElement buttonCreate = wait.until(
                webDriver -> webDriver.findElement(By.id("create-btn")));
        buttonCreate.click();

        WebElement fieldTitle = wait.until(
                webDriver -> webDriver.findElement(By.xpath("//input[@type='text']")));
        fieldTitle.sendKeys("TestSelenium");
        WebElement fieldDescription = driver.findElement
                (By.xpath("//textarea[@class='mdc-text-field__input' and @maxlength='100']"));
        fieldDescription.sendKeys("Home Work 1");
        WebElement buttonSave = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonSave.click();

        WebElement headingPost = wait.until(
                webDriver -> webDriver.findElement(By.cssSelector("h1[class='svelte-tv8alb']")));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshotPost.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("TestSelenium", headingPost.getText());

    }

    @AfterAll
    static void finish() {
        driver.quit();
    }
}
