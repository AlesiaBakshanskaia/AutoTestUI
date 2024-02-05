package homeWork2;

import org.homeWork2.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationTest extends HomeWork2AbstractTest{

    @Test
    void testEmptyLoginAndPasswordAuthorization() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.authorize("", "");

        WebElement textErrorAuthorization = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Invalid')]")));
        Assertions.assertEquals("Invalid credentials.", textErrorAuthorization.getText());
        WebElement numErrorAuthorization = driver
                .findElement(By.xpath("//h2[@class='svelte-uwkxn9']"));
        Assertions.assertEquals("401", numErrorAuthorization.getText());
        Thread.sleep(10000L);
    }
}
