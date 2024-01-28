package homeWork2;

import org.homeWork2.CredentialsModalWindowPage;
import org.homeWork2.EditingDummyPage;
import org.homeWork2.LoginPage;
import org.homeWork2.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DummyTest extends HomeWork2AbstractTest {
    @Test
    void testEditingDummyById() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.authorize("GB202306611b511", "2ee4e216d5");

        StudentPage studentPage = new StudentPage(driver);
        studentPage.openEditingDummyById("18621");
        EditingDummyPage editingDummyPage = new EditingDummyPage(driver, wait);
        final String testName = String.valueOf(System.currentTimeMillis());//для получения уникальных имен Dummy
        editingDummyPage.editDummyName(testName, "Тест");
        Assertions.assertEquals("Тест " + testName, studentPage.getNameDummyById("18621"));
    }

    @Test
    void testCredentialsModalWindow() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.authorize("GB202306611b511", "2ee4e216d5");

        StudentPage studentPage = new StudentPage(driver);
        studentPage.openCredentialsModalById("18621");
        CredentialsModalWindowPage cmwp = new CredentialsModalWindowPage(driver, wait);
        Assertions.assertEquals("Dummy credentials", cmwp.getTextHeaderModalWindow());
        Assertions.assertEquals("CLOSE", cmwp.getTextCloseModalWindowButton());
        Assertions.assertTrue(cmwp.checkTextInContentModalWindow("Login"));
        Assertions.assertTrue(cmwp.checkTextInContentModalWindow("PW"));
    }

}
