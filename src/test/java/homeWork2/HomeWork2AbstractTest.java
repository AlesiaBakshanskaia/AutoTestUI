package homeWork2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HomeWork2AbstractTest {
    static RemoteWebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void init() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("120");
//        capabilities.setCapability("enableVNC",true);
        ChromeOptions options = new ChromeOptions();
        options.setCapability("enableVNC",true);
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        // Без selenoid
//        driver = new ChromeDriver(options);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    @AfterAll
    static void finish() {
        driver.quit();
    }
}
